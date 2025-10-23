package Nat20Network.Network.dungeonMaster;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface dmRepository extends JpaRepository<dm, Long>{
    boolean existsByEmail(String email);
    Optional<dm> findByEmail(String email);
}
