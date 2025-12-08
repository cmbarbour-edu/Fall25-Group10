package Nat20.Network.campaign;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import Nat20.Network.dungeonMaster.*;
import Nat20.Network.players.*;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class CampaignController {
    private final CampaignService campaignService;
    private final DMService dmService;
    private final PlayerService playerService;
    
    // Campaign forms
    @GetMapping("/campaigns")
    public Object getAllPublicCampaigns(Model model) {
        model.addAttribute("campaignList", campaignService.getAllPublicCampaigns());
        model.addAttribute("title", "Campaigns:");
        return "campaign-list";
    }

    @GetMapping("/DMs/{dmID}/campaigns/createForm")
    public Object showCreateCampaignForm(@PathVariable Long dmID, Model model) {
        DM dm = dmService.getDMById(dmID);
        Campaign campaign = new Campaign();
        model.addAttribute("campaign", campaign);
        model.addAttribute("DM", dm);
        model.addAttribute("title", "Add a new campaign");
        return "campaign-create";
    }

    @PostMapping("/DMs/{dmID}/campaigns")
    public Object addCampaign(@PathVariable Long dmID, Campaign campaign) {
        DM dm = dmService.getDMById(dmID);
        Campaign newCampaign = campaignService.createCampaign(campaign, dm);
        newCampaign.setDm(dmService.getDMById(dmID));
        return "redirect:/DMs/" + dmID + "/campaigns/" + newCampaign.getCampaignID(); 
    }

    @GetMapping("/DMs/{dmID}/campaigns/{campaignID}/updateForm")
    public Object showUpdateForm(@PathVariable Long dmID, @PathVariable Long campaignID, Model model) {
        Campaign campaign = campaignService.getCampaignById(campaignID);
        DM dm = dmService.getDMById(dmID);
        if (dm == campaign.getDm()) {
            model.addAttribute("campaign", campaign);
            model.addAttribute("DM", dm);
            model.addAttribute("title", "Update Campaign");
            return "campaign-update";
        }
        else return "redirect:/DMs/" + dmID + "/home";
        
    }

    @PostMapping("/DMs/{dmID}/campaigns/{campaignID}/update")
    public Object updateCampaign(@PathVariable Long dmID, @PathVariable Long campaignID, Campaign campaignDetails) {
        campaignService.updateCampaign(campaignID, campaignDetails);
        return "redirect:/DMs/" + dmID + "/campaigns/" + campaignID;
    }

    @GetMapping("/DMs/{dmID}/campaigns/{campaignID}")
    public Object getCampaignByIDAndDm(@PathVariable Long dmID, @PathVariable Long campaignID, Model model) {
        DM dm = dmService.getDMById(dmID);
        Campaign campaign = campaignService.getCampaignById(campaignID);
        model.addAttribute("campaign", campaign);
        model.addAttribute("DM", dm);
        model.addAttribute("playerList", campaign.getPlayers());
        model.addAttribute("title", campaignService.getCampaignById(campaignID).getTitle());
        return "dm-campaign-details";
    }

    @GetMapping("/DMs/{dmID}/campaigns/{campaignID}/delete")
    public Object deleteCampaign(@PathVariable Long dmID, @PathVariable Long campaignID) {
        DM dm = dmService.getDMById(dmID);
        Campaign campaign = campaignService.getCampaignById(campaignID);
        if (dm == campaign.getDm()) {
            campaignService.deleteCampaign(campaignID);
            return "redirect:/DMs/" + dmID + "/home";
        }
        else return "redirect:/DMs/" + dmID + "/campaigns";
        
    }

    @GetMapping("/DMs/{dmID}/campaigns")
    public Object getCampaignsByDm(@PathVariable Long dmID, Model model) {
        DM dm = dmService.getDMById(dmID);
        model.addAttribute("DM", dm);
        model.addAttribute("campaignList", dm.getCampaigns());
        model.addAttribute("title", "Campaigns by @${DM.username}");
        return "dm-campaign-list";
    }
    @GetMapping("/DMs/{dmID}/campaigns/{campaignID}/players/{playerID}/remove")
    public Object removePlayer(@PathVariable Long dmID, @PathVariable Long campaignID, @PathVariable Long playerID, Model model) {
        DM dm = dmService.getDMById(dmID);
        Campaign campaign = campaignService.getCampaignById(campaignID);
        Player player = playerService.getPlayerById(playerID);
        if (dm == campaign.getDm()) {
            campaignService.removePlayer(campaign, player);
            return "redirect:/DMs/" + dmID + "/campaigns/" + campaignID;
        }
        else return "redirect:/DMs/" + dmID + "/home";
    }

}
