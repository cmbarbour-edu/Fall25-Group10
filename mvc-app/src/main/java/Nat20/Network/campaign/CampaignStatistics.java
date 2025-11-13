package Nat20.Network.campaign;

import lombok.Data;
import java.util.Map;

@Data
public class CampaignStatistics {
    
    private double averageOverallRating;
    private double averageCampaignRating;
    private double averageDMRating;
    private Map<String, Double> ratingsByCampaign;

    private long totalReviews;
    private double responseRate; 
    private Map<Double, Long> ratingDistribution;

    private int totalCampaigns;
    private int activeCampaigns;
    private Map<String, Long> mostPopularCampaigns;
}
