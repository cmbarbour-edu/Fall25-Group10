package Nat20.Network.review;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Nat20.Network.campaign.Campaign;
import Nat20.Network.campaign.CampaignService;
import Nat20.Network.dungeonMaster.DMService;
import Nat20.Network.players.PlayerService;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    private final PlayerService playerService;
    private final DMService dmService;
    private final CampaignService campaignService;

    @PostMapping
    public ResponseEntity<Review> createReview(@Valid @RequestBody Review review) {
        Review createdReview = reviewService.createReview(review);
        return ResponseEntity.ok(createdReview);
    }

    @PostMapping("/{id}/dmresponse")
    public ResponseEntity<Review> respondToReview(@PathVariable Long id, @RequestBody String dmResponse) {
        Review updatedReview = reviewService.respondToReview(id, dmResponse);
        return ResponseEntity.ok(updatedReview);
    }

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


    @GetMapping("/dm/{dmid}")
    public ResponseEntity<List<Review>> getReviewsByDM(@PathVariable Long dmid) {
        var dm = dmService.getDMById(dmid);
        List<Review> reviews = reviewService.getReviewsByDM(dm);
        return ResponseEntity.ok(reviews);
    }

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
}
