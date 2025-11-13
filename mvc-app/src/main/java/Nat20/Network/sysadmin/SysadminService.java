package Nat20.Network.sysadmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Nat20.Network.campaign.Campaign;
import Nat20.Network.campaign.CampaignRepository;
import Nat20.Network.dungeonMaster.DM;
import Nat20.Network.dungeonMaster.DMRepository;
import Nat20.Network.players.Player;
import Nat20.Network.players.PlayerRepo;
import Nat20.Network.review.Review;
import Nat20.Network.review.ReviewRepository;

import java.util.List;

@Service
public class SysadminService {
    @Autowired
    private PlayerRepo playerRepository;

    @Autowired  
    private ReviewRepository reviewRepository;

    @Autowired
    private DMRepository dmRepository;

    @Autowired
    private CampaignRepository campaignRepository;

    //@Autowired  
    //private StatisticsRepository statisticsRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public List<DM> getAllDMs() {
        return dmRepository.findAll();
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public void deletePlayerById(Long playerId) {
        playerRepository.deleteById(playerId);
    }

    public void deleteReviewById(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    public void deleteDMById(Long dmId) {
        dmRepository.deleteById(dmId);
    }

    public Player updatePlayer(Long playerID, Player player) {
        return playerRepository.save(player);
    }

    public DM updateDM(Long dmID, DM dm) {
        return dmRepository.save(dm);
    }

    //public List<Statistics> getAllStatistics() {
    //    return statisticsRepository.findAll();
    //}

    public void deleteServiceById(Long campaignId) {
        campaignRepository.deleteById(campaignId);
    }

    public List<Review> getAllReviewsForService(Campaign campaign) {
        return reviewRepository.findByCampaign(campaign);
    }

}
 