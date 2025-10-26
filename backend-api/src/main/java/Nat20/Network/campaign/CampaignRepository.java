package Nat20.Network.campaign;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Nat20.Network.dungeonMaster.DM;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long>{
    @Query(value = "select * from campaigns c where c.title like %?1%", nativeQuery = true)
    List<Campaign> findByTitle(DM dmId);

    @Query(value = "select * from campaigns c where c.edition like %?1%", nativeQuery = true)
    List<Campaign> findByEdition(String edition);

    boolean existsByTitle(String title);
}
