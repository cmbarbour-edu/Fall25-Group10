package Nat20.Network.review;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Nat20.Network.campaign.Campaign;
import Nat20.Network.dungeonMaster.DM;
import Nat20.Network.players.Player;

import java.time.LocalDateTime;
import java.util.List;
import java.util.OptionalDouble;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public double getAverageOverallRating(Campaign campaign) {
        List<Review> reviews = reviewRepository.findByCampaign(campaign);
        OptionalDouble average = reviews.stream()
                .mapToDouble(review -> review.getOverallRating() != null ? review.getOverallRating() : 0.0)
                .average();
        return average.orElse(0.0);
    }

    public double getAverageCampaignRating(Campaign campaign) {
        List<Review> reviews = reviewRepository.findByCampaign(campaign);
        OptionalDouble average = reviews.stream()
                .mapToDouble(review -> review.getCampaignRating() != null ? review.getCampaignRating() : 0.0)
                .average();
        return average.orElse(0.0);
    }

    public double getAveragedmRating(Campaign campaign) {
        List<Review> reviews = reviewRepository.findByCampaign(campaign);
        OptionalDouble average = reviews.stream()
                .mapToDouble(review -> review.getDmRating() != null ? review.getDmRating() : 0.0)
                .average();
        return average.orElse(0.0);
    }

    public Review createReview(Review review) {
        double campaignRating = review.getCampaignRating() != null ? review.getCampaignRating() : 0;
        double dmRating = review.getDmRating() != null ? review.getDmRating() : 0;
        review.setOverallRating(Double.valueOf(dmRating + campaignRating) / 2);
        review.setCreatedAt(LocalDateTime.now());
        return reviewRepository.save(review);

}

    public Review respondToReview(Long reviewId, String dmResponse) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new EntityNotFoundException("Review not found with id: " + reviewId));
        review.setDmResponse(dmResponse);
        review.setDmResponseDate(LocalDateTime.now());
        return reviewRepository.save(review);
    }

    public void deleteReview(Long reviewId) {
       if (!reviewRepository.existsById(reviewId)) {
            throw new EntityNotFoundException("Review not found with id: " + reviewId);
        }
        reviewRepository.deleteById(reviewId);
    }

    public List<Review> getReviewsByCampaign(Campaign campaign) {
        return reviewRepository.findByCampaign(campaign);
    }

    public List<Review> getReviewsByPlayer(Player player) {
        return reviewRepository.findByPlayer(player);
    }

    public List<Review> getReviewsByDM(DM dm) {
        return reviewRepository.findByDungeonMaster(dm);
    }
}
