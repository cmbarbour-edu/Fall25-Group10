package Nat20.Network.campaign;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/campaigns")
@RequiredArgsConstructor
public class CampaignController {
    private final CampaignService campaignService;
    
    // Campaign forms
    @GetMapping
    public Object viewAllCampaigns(Model model) {
        model.addAttribute("campaigns", campaignService.getAllCampaigns());
        model.addAttribute("title", "Campaigns:");
        return "campaign-list";
    }

    @GetMapping("/createForm")
    public Object showCreateCampaignForm(Model model) {
        Campaign campaign = new Campaign();
        model.addAttribute("campaign", campaign);
        model.addAttribute("title", "Add a new campaign");
        return "campaign-create";
    }

    @PostMapping
    public Object addCampaign(Campaign campaign) {
        Campaign newCampaign = campaignService.createCampaign(campaign);
        return "redirect:/campaigns/" + newCampaign.getCampaignID(); 
    }

    @GetMapping("/updateForm/{campaignID}")
    public Object showUpdateForm(@PathVariable Long campaignID, Model model) {
        Campaign campaign = campaignService.getCampaignById(campaignID);
        model.addAttribute("Campaign", campaign);
        model.addAttribute("title", "Update Campaign");
        return "campaign-update";
    }

    @PostMapping("/{campaignID}/update")
    public Object updateCampaign(@PathVariable Long campaignID, Campaign campaignDetails) {
        campaignService.updateCampaign(campaignID, campaignDetails);
        return "redirect:/campaigns/" + campaignID;
    }

    @GetMapping("/{campaignID}")
    public Object getCampaignByID(@PathVariable Long campaignID, Model model) {
        model.addAttribute("Campaign", campaignService.getCampaignById(campaignID));
        model.addAttribute("title", campaignService.getCampaignById(campaignID).getTitle());
        return "campaign-details";
    }

    @GetMapping("/{campaignID}/delete")
    public Object deleteDm(@PathVariable Long campaignID) {
        campaignService.deleteCampaign(campaignID);
        return "redirect:/home";
    }

}
