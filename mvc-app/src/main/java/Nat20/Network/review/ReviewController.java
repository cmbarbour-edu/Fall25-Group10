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

    /*
    @PostMapping
    public ResponseEntity<Review> createReview(@Valid @RequestBody Review review) {
        Review createdReview = reviewService.createReview(review);
        return ResponseEntity.ok(createdReview);
    }
    */

    @PostMapping("/DMs/{dmID}/reviews/{reviewID}/dmresponse")
    public Object respondToReview(@PathVariable Long dmID, @PathVariable Long reviewID, String dmResponse) {
        reviewService.respondToReview(reviewID, dmResponse);
        return "redirect:/DMs/" + dmID + "/reviews";
    }

    /*
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/campaign/{campaignId}") 
    public ResponseEntity<List<Review>> getReviewsByCampaign(@PathVariable Long campaignId) {
        var campaign = campaignService.getCampaignById(campaignId);
        List<Review> reviews = reviewService.getReviewsByCampaign(campaign);
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/player/{playerId}")
    public ResponseEntity<List<Review>> getReviewsByPlayer(@PathVariable Long playerId) {
        var player = playerService.getPlayerById(playerId);
        List<Review> reviews = reviewService.getReviewsByPlayer(player);
        return ResponseEntity.ok(reviews);

    }
    */

    @GetMapping("/DMs/{dmID}/reviews")
    public Object getReviewsByDM(@PathVariable Long dmID, Model model) {
        DM dm = dmService.getDMById(dmID);
        model.addAttribute("DM", dm);
        model.addAttribute("reviewList", reviewService.getReviewsByDM(dm));
        model.addAttribute("title", "Reviews for @${DM.username}");
        return "dm-reviews";
    }

    /*
    @GetMapping("/campaign/{campaignId}/ratings")
    public ResponseEntity<Map<String, Double>> getAverageRatingsForCampaign(@PathVariable Long campaignId) {
        Campaign campaign = campaignService.getCampaignById(campaignId);
        double averageOverallRating = reviewService.getAverageOverallRating(campaign);
        double averageCampaignRating = reviewService.getAverageCampaignRating(campaign);
        double averagedmRating = reviewService.getAveragedmRating(campaign);

        Map<String, Double> ratings = new HashMap<>();
        ratings.put("Overall", averageOverallRating);
        ratings.put("Campaign", averageCampaignRating);
        ratings.put("dm", averagedmRating);

        return ResponseEntity.ok(ratings);
    }
    */
}
