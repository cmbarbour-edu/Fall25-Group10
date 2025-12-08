package Nat20.Network.campaign;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long>{
    @Query(value = "select * from campaigns c where c.title like %?1%", nativeQuery = true)
    List<Campaign> findByTitle(String title);

    @Query(value = "select * from campaigns c where c.edition like %?1%", nativeQuery = true)
    List<Campaign> findByEdition(String edition);

    @Query(value = "select * from campaigns c where c.isPublic is true", nativeQuery = true)
    List<Campaign> findByIsPublicTrue();


    boolean existsByTitle(String title);

    @Query(value = "select * from campaigns c where dm_id = ?1", nativeQuery = true)
    List<Campaign> findByDm(Long dmID);
}
