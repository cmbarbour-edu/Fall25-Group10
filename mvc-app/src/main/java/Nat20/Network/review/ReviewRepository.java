package Nat20.Network.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Nat20.Network.campaign.Campaign;
import Nat20.Network.dungeonMaster.DM;
import Nat20.Network.players.Player;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{
    List<Review> findBydm(DM dm_id);
    List<Review> findByPlayer(Player player);
    List<Review> findByCampaign(Campaign campaign);
}
