package Nat20.Network.campaign;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Nat20.Network.dungeonMaster.DM;
import Nat20.Network.players.Player;
import Nat20.Network.players.PlayerRepo;

@Service
@RequiredArgsConstructor
@Transactional
public class CampaignService {
	private final CampaignRepository campaignRepository;
    private final PlayerRepo playerRepository;

    public Campaign createCampaign(Campaign campaign, DM dm) {
        if (campaignRepository.existsByTitle(campaign.getTitle())) {
            throw new IllegalStateException("A campaign with this title already exists.");
        }
        campaign.setDm(dm);
        return campaignRepository.save(campaign);
    }

    public Campaign updateCampaign(Long id, Campaign campaignDetails) {
        Campaign existingCampaign = campaignRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Campaign not found with id: " + id));

        if (!existingCampaign.getTitle().equals(campaignDetails.getTitle()) &&
                campaignRepository.existsByTitle(campaignDetails.getTitle())) {
            throw new IllegalStateException("A campaign with this title already exists.");
        }
        existingCampaign.setTitle(campaignDetails.getTitle());
        existingCampaign.setEdition(campaignDetails.getEdition());
        existingCampaign.setDescription(campaignDetails.getDescription());
        existingCampaign.setShortDescription(campaignDetails.getShortDescription());
        existingCampaign.setIsPublic(campaignDetails.getIsPublic());
        return campaignRepository.save(existingCampaign);
    }

    public Object getAllPublicCampaigns() {
        return campaignRepository.findByIsPublicTrue();
    }
    
    public Campaign getCampaignById(Long id) {
        return campaignRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Campaign not found with id: " + id));
    }
    
    public void deleteCampaign(Long id) {
        if (!campaignRepository.existsById(id)) {
            throw new EntityNotFoundException("Campaign not found with id: " + id);
        }
        campaignRepository.deleteById(id);
    }

    public void removePlayer(Campaign campaign, Player player) {
        campaign.removePlayer(player);
        campaignRepository.save(campaign);
        playerRepository.save(player);
    }
}
