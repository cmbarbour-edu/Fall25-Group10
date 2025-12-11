package Nat20.Network.review;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import Nat20.Network.campaign.Campaign;
import Nat20.Network.campaign.CampaignService;
import Nat20.Network.dungeonMaster.DM;
import Nat20.Network.dungeonMaster.DMService;
import Nat20.Network.players.Player;
import Nat20.Network.players.PlayerService;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    private final PlayerService playerService;
    private final DMService dmService;
    private final CampaignService campaignService;

    @GetMapping("/campaign/{campaignID}/reviews/new")
    public String showCreateReviewForm(@PathVariable Long campaignID, Model model) {
        model.addAttribute("review", new Review());
        model.addAttribute("campaignID", campaignID);
        model.addAttribute("title", "Create Review");
        return "review-form";
    }

    @PostMapping("/campaign/{campaignID}/reviews")
    public String createReview(@PathVariable Long campaignID, @Valid Review review) {
    Campaign campaign = campaignService.getCampaignById(campaignID);
    review.setCampaign(campaign);
    reviewService.createReview(review);
    return "redirect:/campaign/" + campaignID + "/reviews";
}
    

    @PostMapping("/DMs/{dmID}/reviews/{reviewID}/dmresponse")
    public Object respondToReview(@PathVariable Long dmID, @PathVariable Long reviewID, @RequestParam String dmResponse) {
        reviewService.respondToReview(reviewID, dmResponse);
        return "redirect:/DMs/" + dmID + "/reviews";
    }

    @GetMapping("/campaign/{campaignId}/reviews") 
    public String getReviewsByCampaign(@PathVariable Long campaignId, Model model) {
        Campaign campaign = campaignService.getCampaignById(campaignId);
        model.addAttribute("campaign", campaign);
        model.addAttribute("reviewList", reviewService.getReviewsByCampaign(campaign));
        model.addAttribute("title", "Reviews for " + campaign.getTitle());
        return "reviews-campaign";
    }
    
    @GetMapping("/player/{playerId}/reviews")
    public String getReviewsByPlayer(@PathVariable Long playerId, Model model) {
        Player player = playerService.getPlayerById(playerId);
        model.addAttribute("player", player);
        model.addAttribute("reviewList", reviewService.getReviewsByPlayer(player));
        model.addAttribute("title", "Reviews by @${player.username}");
        return "reviews-player";

    }
    

    @GetMapping("/DMs/{dmID}/reviews")
    public Object getReviewsByDM(@PathVariable Long dmID, Model model) {
        DM dm = dmService.getDMById(dmID);
        model.addAttribute("dm", dm);
        model.addAttribute("reviewList", reviewService.getReviewsByDM(dm));
        model.addAttribute("title", "Reviews for @${dm.username}");
        return "dm-reviews";
    }

    
    @GetMapping("/campaign/{campaignId}/ratings")
    public String getAverageRatingsForCampaign(@PathVariable Long campaignId, Model model) {
        Campaign campaign = campaignService.getCampaignById(campaignId);
        double averageOverallRating = reviewService.getAverageOverallRating(campaign);
        double averageCampaignRating = reviewService.getAverageCampaignRating(campaign);
        double averagedmRating = reviewService.getAveragedmRating(campaign);

        model.addAttribute("campaign", campaign);
        model.addAttribute("averageOverallRating", averageOverallRating);
        model.addAttribute("averageCampaignRating", averageCampaignRating);
        model.addAttribute("averagedmRating", averagedmRating);

        return "reviews-campaign-ratings";
    }
    
}
