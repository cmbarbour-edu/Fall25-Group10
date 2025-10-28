package Nat20.Network.dungeonMaster;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DMRepository extends JpaRepository<DM, Long>{
    boolean existsByEmail(String email);
    Optional<DM> findByEmail(String email);
}
