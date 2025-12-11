package Nat20.Network.sysadmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import Nat20.Network.campaign.Campaign;
import Nat20.Network.dungeonMaster.DM;
import Nat20.Network.players.Player;
import Nat20.Network.review.Review;

import java.util.List;

// @RestController
@Controller
@RequestMapping("/sysadmin")
public class SysadminController {
    @Autowired
    private SysadminService sysadminService;

    @GetMapping("/home")
    public String sysadminHome() {
        return "sysadmin-home"; // -> sysadmin-home.ftlh
    }

    @GetMapping("/profile")
    public String sysadminProfile() {
        return "sysadmin-profile"; // -> sysadmin-profile.ftlh
    }

    @GetMapping("/reviews")
    public String getAllReviews(Model model) {
        List<Review> reviews = sysadminService.getAllReviews();
        model.addAttribute("reviews", reviews);
        return "sysadmin-reviews";
        // return sysadminService.getAllReviews();
}

    @PostMapping("/reviews/{id}/delete")
    public String deleteReview(@PathVariable Long id) {
        sysadminService.deleteReviewById(id);
        return "redirect:/sysadmin/reviews";
    }

    @GetMapping("/dms")
    public String getAllDMs(Model model) {
       List<DM> dms = sysadminService.getAllDMs();
       model.addAttribute("dms", dms);
         return "sysadmin-dms";
        // return sysadminService.getAllDMs();
    }

    @GetMapping("/players")
    public String getAllPlayers(Model model) {
        List<Player> players = sysadminService.getAllPlayers();
        model.addAttribute("players", players);
        return "sysadmin-players";
        // return sysadminService.getAllPlayers();
    }

    @GetMapping("/players/{id}/edit")
    public String editPlayerForm(@PathVariable Long id, Model model) {
        Player player = sysadminService.getPlayerById(id);
        model.addAttribute("player", player);
        return "sysadmin-edit-player"; // -> edit-player.ftlh
    }

    @PostMapping("/players/{id}/edit")
    public String updatePlayer(@PathVariable Long id, @ModelAttribute Player player) {
        sysadminService.updatePlayer(id, player);
        return "redirect:/sysadmin/players";
        // return sysadminService.updatePlayer(id, player);
    }

    @PostMapping("/players/{id}/delete")
    public String deletePlayer(@PathVariable Long id) {
        sysadminService.deletePlayerById(id);
        return "redirect:/sysadmin/players";
    }

    @PostMapping("/dms/{id}/edit")
    public String updateDM(@PathVariable Long id, @ModelAttribute DM dm) {
        sysadminService.updateDM(id, dm);
        return "redirect:/sysadmin/dms";
        // return sysadminService.updateDM(id, dm);
    }

    @PostMapping("/dms/{id}/delete")
    public String deleteDM(@PathVariable Long id) {
        sysadminService.deleteDMById(id);
        return "redirect:/sysadmin/dms";
    }

    @GetMapping("/dms/{id}/edit")
    public String editDMForm(@PathVariable Long id, Model model) {
        DM dm = sysadminService.getDMById(id);
        model.addAttribute("dm", dm);
        return "sysadmin-edit-dm"; // -> edit-dm.ftlh
    }

    //@GetMapping("/statistics")
    //public List<Statistics> getAllStatistics() {
       // return sysadminService.getAllStatistics();
    //} updated i'll finish later

    @PostMapping("/campaigns/{id}/delete")
    public String deleteCampaign(@PathVariable Long id) {
        sysadminService.deleteServiceById(id);
        return "redirect:/sysadmin/campaigns";
    }

    @GetMapping("/campaigns")
    public String getAllCampaigns(Model model) {
        List<Campaign> campaigns = sysadminService.getAllCampaigns();
        model.addAttribute("campaigns", campaigns);
        return "sysadmin-campaigns";
        // return sysadminService.getAllCampaigns();
    }

    @GetMapping("/campaigns/{id}/edit")
    public String editCampaignForm(@PathVariable Long id, Model model) {
        Campaign campaign = sysadminService.getCampaignById(id);
        model.addAttribute("campaign", campaign);
        return "sysadmin-edit-campaign"; // -> edit-campaign.ftlh
    }

    @PostMapping("/campaigns/{id}/edit")
    public String updateCampaign(@PathVariable Long id, @ModelAttribute Campaign campaign) {
        sysadminService.updateCampaign(id, campaign);
        return "redirect:/sysadmin/campaigns";
    }

}
