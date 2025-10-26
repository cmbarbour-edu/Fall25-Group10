package Nat20.Network.sysadmin;

import org.apache.naming.ServiceRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Nat20.Network.review.Review;

import java.util.List;

@Service
public class SysadminService {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired  
    private ReviewRepository reviewRepository;

    @Autowired
    private DMRepository dmRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired  
    private StatisticsRepository statisticsRepository;

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

    public List<Statistics> getAllStatistics() {
        return statisticsRepository.findAll();
    }

    public void deleteServiceById(Long serviceId) {
        serviceRepository.deleteById(serviceId);
    }

    public List<Review> getAllReviewsForService(Long serviceId) {
        return reviewRepository.findByServiceId(serviceId);
    }

}
 