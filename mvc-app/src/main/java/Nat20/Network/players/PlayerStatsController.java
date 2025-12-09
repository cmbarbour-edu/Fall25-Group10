package Nat20.Network.players;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import Nat20.Network.dungeonMaster.DM;
import Nat20.Network.dungeonMaster.DMService;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class PlayerStatsController {
    private final DMService dmService;
    private final PlayerService playerService;

    @GetMapping("/DMs/{dmID}/players/{playerID}/stats")
    public Object viewPlayerStats(@PathVariable Long dmID, @PathVariable Long playerID, Model model) {
        DM dm = dmService.getDMById(dmID);
        Player player = playerService.getPlayerById(playerID);
        PlayerStats stats = player.getStats();
        model.addAttribute("DM", dm);
        model.addAttribute("Player", player);
        model.addAttribute("campaignList", player.getCampaigns());
        model.addAttribute("Stats", stats);
        model.addAttribute("Title", "Player Stats:");
        return "dm-player-stats";
    }

}