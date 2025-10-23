package Nat20.Network.players;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import Nat20.Network.players.*;

@Repository
public class PlayerRepo extends JpaRepository<Player, Long>{
    
}
