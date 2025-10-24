package Nat20.Network.requests;

import Nat20.Network.players.*;
import Nat20.Network.dungeonMaster.*;
import Nat20.Network.campaign.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface RequestsRepo extends JpaRepository<Requests, Long>{
    List<Requests> findByPlayerAndActive(Player player, boolean active);
    List<Requests> findByCampaign(Campaign campaign);
    List<Requests> findByDM(DM dm);
}
