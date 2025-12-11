package Nat20.Network.review;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import Nat20.Network.campaign.Campaign;
import Nat20.Network.campaign.CampaignService;
import Nat20.Network.dungeonMaster.DMService;
import Nat20.Network.players.PlayerService;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

// @RestController
@Controller
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    private final PlayerService playerService;
    private final DMService dmService;
    private final CampaignService campaignService;

    @GetMapping("/new")
    public String showCreateReviewForm(Model model) {
        model.addAttribute("review", new Review());
        return "reviews-create"; // -> create.ftlh
    }

    @PostMapping
    public String createReview(@Valid @RequestBody Review review, Model model) {
        Review createdReview = reviewService.createReview(review);
        model.addAttribute("review", createdReview);
        return "reviews-details"; // -> details.ftlh
    }

    @PostMapping("/{id}/dmresponse")
    public String respondToReview(@PathVariable Long id, @RequestBody String dmResponse, Model model) {
        Review updatedReview = reviewService.respondToReview(id, dmResponse);
        model.addAttribute("review", updatedReview);
        return "reviews-details"; // -> details.ftlh
       // return ResponseEntity.ok(updatedReview);
    }

    @PostMapping("/{id}/delete")
    public String deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return "redirect:/api/reviews";
       // return ResponseEntity.ok().build();
    }

    @GetMapping("/campaign/{campaignId}") 
    public String getReviewsByCampaign(@PathVariable Long campaignId, Model model) {
        var campaign = campaignService.getCampaignById(campaignId);
        List<Review> reviews = reviewService.getReviewsByCampaign(campaign);
        model.addAttribute("campaign", campaign);
        model.addAttribute("reviews", reviews);
        return "reviews-list"; // -> list.ftlh
        // return ResponseEntity.ok(reviews);
    }

    @GetMapping("/player/{playerId}")
    public String getReviewsByPlayer(@PathVariable Long playerId, Model model) {
        var player = playerService.getPlayerById(playerId);
        List<Review> reviews = reviewService.getReviewsByPlayer(player);

        model.addAttribute("player", player);
        model.addAttribute("reviews", reviews);
        return "reviews-list"; // -> list.ftlh
        // return ResponseEntity.ok(reviews);

}


    @GetMapping("/dm/{dmid}")
    public String getReviewsByDM(@PathVariable Long dmid, Model model) {
        var dm = dmService.getDMById(dmid);
        List<Review> reviews = reviewService.getReviewsByDM(dm);

        model.addAttribute("dm", dm);
        model.addAttribute("reviews", reviews);
        return "reviews-list"; // -> list.ftlh
       // return ResponseEntity.ok(reviews);
    }

    @GetMapping("/campaign/{campaignId}/ratings")
    public String getAverageRatingsForCampaign(@PathVariable Long campaignId, Model model) {
        Campaign campaign = campaignService.getCampaignById(campaignId);
        double averageOverallRating = reviewService.getAverageOverallRating(campaign);
        double averageCampaignRating = reviewService.getAverageCampaignRating(campaign);
        double averagedmRating = reviewService.getAveragedmRating(campaign);

        Map<String, Double> ratings = new HashMap<>();
        ratings.put("Overall", averageOverallRating);
        ratings.put("Campaign", averageCampaignRating);
        ratings.put("dm", averagedmRating);

        model.addAttribute("campaign", campaign);
        model.addAttribute("ratings", ratings);
        return "reviews-ratings"; // -> ratings.ftlh

       // return ResponseEntity.ok(ratings);
    }
}
