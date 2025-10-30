package Nat20.Network.players;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Nat20.Network.campaign.*;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional

public class PlayerService {
    private final PlayerRepo playerRepo;
    private final CampaignRepository campaignRepo;

    public Player createPlayer(Player player) {
        if (playerRepo.existsByEmail(player.getEmail())) {
            throw new IllegalStateException("Email already registered");
        }
        return playerRepo.save(player);
    }

    public Player updatePlayer(Long id, Player playerDetails) {
        Player player = playerRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Player not found"));

        player.setName(playerDetails.getName());
        player.setEmail(playerDetails.getEmail());

        return playerRepo.save(player);
    }

    public Player getPlayerById(Long id) {
        return playerRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Player not found"));
    }

    public List<Player> getAllPlayers() {
        return playerRepo.findAll();
    }

    public void deletePlayer(Long id) {
        if (!playerRepo.existsById(id)) {
            throw new EntityNotFoundException("Player not found");
        }
        playerRepo.deleteById(id);
    }

    public void addPlayerToCampaign(Long playerId, Long campaignId) {
        Player player = playerRepo.findById(playerId)
                .orElseThrow(() -> new EntityNotFoundException("Player not found"));

        Campaign campaign = campaignRepo.findById(campaignId)
                .orElseThrow(() -> new EntityNotFoundException("Campaign not found"));

        // Use helper: updates both sides
        // player.addCampaign(campaign);
       // campaign.addPlayer(player);
        campaign.getPlayers().add(player);

        // Save owning side to persist join table
        campaignRepo.save(campaign);
    }
}
