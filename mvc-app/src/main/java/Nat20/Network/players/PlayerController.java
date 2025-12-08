package Nat20.Network.players;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/players")
@RequiredArgsConstructor

public class PlayerController {
    private final PlayerService playerService;
    
     @GetMapping("/createForm")
    public Object showCreatePlayerForm(Model model) {
        Player player = new Player();
        model.addAttribute("player", player);
        model.addAttribute("title", "Add a new player");
        return "player-create";
    }

    @PostMapping
    public Object addPlayer(Player player) {
        Player newPlayer = playerService.createPlayer(player);
        return "redirect:/players/" + newPlayer.getPlayerID() + "/home";
    }

    @GetMapping("/{id}/update")
    public Object showUpdateForm(@PathVariable Long id, Model model) {
        Player player = playerService.getPlayerById(id);
        model.addAttribute("player", player);
        
        model.addAttribute("title", "Update Player");
        return "player-update";
    }

    @PostMapping("/{id}")
    public Object updatePlayer(@PathVariable Long id, Player playerDetails) {
        playerService.updatePlayer(id, playerDetails);
        return "redirect:/players/" + id + "/profile";
    }

    @GetMapping("/{id}/home")
    public Object getPlayerByID(@PathVariable Long id, Model model) {
        Player player = playerService.getPlayerById(id);
        model.addAttribute("player", player);
        model.addAttribute("title", "Player:");
        return "playerhome";
    }

    @GetMapping("/{id}/delete")
    public Object deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return "redirect:/home";
    }

    // Player Profile details
    @GetMapping("/{id}/profile")
    public Object viewPlayer(@PathVariable Long id, Model model) {
        Player player = playerService.getPlayerById(id);
        model.addAttribute("player", player);
        
        model.addAttribute("Title", "Player:");
        return "playerhome";
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
