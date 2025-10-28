package Nat20.Network.players;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerStatsService {

    @Autowired
    private PlayerStatsRepository repository;

    public List<PlayerStats> getAllStats() {
        return repository.findAll();
    }

    public Optional<PlayerStats> getStatsById(Long id) {
        return repository.findById(id);
    }

    public PlayerStats createStats(PlayerStats stats) {
        return repository.save(stats);
    }

    public PlayerStats updateStats(Long id, PlayerStats updatedStats) {
        return repository.findById(id).map(stats -> {
            stats.setNumberOfTimesKicked(updatedStats.getNumberOfTimesKicked());
            stats.setNumberOfCampaigns(updatedStats.getNumberOfCampaigns());
            stats.setHighestLevel(updatedStats.getHighestLevel());
            stats.setFavouriteClass(updatedStats.getFavouriteClass());
            return repository.save(stats);
        }).orElseThrow(() -> new RuntimeException("PlayerStats not found with id " + id));
    }

    public void deleteStats(Long id) {
        repository.deleteById(id);
    }
}

