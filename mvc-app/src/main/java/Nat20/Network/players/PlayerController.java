package Nat20.Network.players;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/players")
@RequiredArgsConstructor

public class PlayerController {
    private final PlayerService playerService;
    
     @GetMapping("/createForm")
    public Object showCreatePlayerForm(Model model) {
        Player player = new Player();
        model.addAttribute("Player", player);
        model.addAttribute("title", "Add a new player");
        return "player-create";
    }

    @PostMapping
    public Object addPlayer(Player player) {
        Player newPlayer = PlayerService.createPlayer(player);
        return "redirect:/players/" + newPlayer.getPlayerByID() + "/home";
    }

    @GetMapping("/{id}/update")
    public Object showUpdateForm(@PathVariable Long id, Model model) {
        Player player = PlayerService.getPlayerById(id);
        model.addAttribute("Player", player);
        
        model.addAttribute("title", "Update Player");
        return "player-update";
    }

    @PostMapping("/{id}")
    public Object updatePlayer(@PathVariable Long id, Player playerDetails) {
        PlayerService.updatePlayer(id, playerDetails);
        return "redirect:/players/" + id + "/profile";
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

    /* 
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
*/
    @PutMapping("/{playerId}/campaigns/{campaignId}")
public ResponseEntity<String> addPlayerToCampaign(
        @PathVariable Long playerId,
        @PathVariable Long campaignId) {
    playerService.addPlayerToCampaign(playerId, campaignId);
    return ResponseEntity.ok("Player added to campaign successfully!");
}
}
