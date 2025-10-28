package Nat20.Network.players;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor

public class PlayerController {
    private final PlayerService playerService;
    private final PlayerStatsService playerStatsService;

    @PostMapping
    public ResponseEntity<Player> createPlayer(@Valid @RequestBody Player player) {
        return ResponseEntity.ok(playerService.createPlayer(player));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Long id, @Valid @RequestBody Player playerDetails) {
        return ResponseEntity.ok(playerService.updatePlayer(id, playerDetails));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayer(@PathVariable Long id) {
        return ResponseEntity.ok(playerService.getPlayerById(id));
    }

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        return ResponseEntity.ok(playerService.getAllPlayers());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{playerId}/stats")
    public ResponseEntity<PlayerStats> getPlayerStats(@PathVariable Long playerId) {
        Player player = playerService.getPlayerById(playerId);
        PlayerStats stats = player.getStats();
        if (stats == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(stats);
    }

    @PostMapping("/{playerId}/stats")
    public ResponseEntity<PlayerStats> createPlayerStats(@PathVariable Long playerId,
                                                         @Valid @RequestBody PlayerStats stats) {
        Player player = playerService.getPlayerById(playerId);
        stats = playerStatsService.createStats(stats);
        player.setStats(stats); // link stats to player
        playerService.updatePlayer(playerId, player);
        return ResponseEntity.ok(stats);
    }

    @PutMapping("/{playerId}/stats")
    public ResponseEntity<PlayerStats> updatePlayerStats(@PathVariable Long playerId,
                                                         @Valid @RequestBody PlayerStats stats) {
        Player player = playerService.getPlayerById(playerId);
        PlayerStats existingStats = player.getStats();
        if (existingStats == null) {
            return ResponseEntity.notFound().build();
        }
        PlayerStats updatedStats = playerStatsService.updateStats(existingStats.getId(), stats);
        return ResponseEntity.ok(updatedStats);
    }

    @DeleteMapping("/{playerId}/stats")
    public ResponseEntity<Void> deletePlayerStats(@PathVariable Long playerId) {
        Player player = playerService.getPlayerById(playerId);
        PlayerStats stats = player.getStats();
        if (stats != null) {
            playerStatsService.deleteStats(stats.getId());
            player.setStats(null);
            playerService.updatePlayer(playerId, player);
        }
        return ResponseEntity.noContent().build();
    }
}
