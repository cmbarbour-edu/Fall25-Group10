package Nat20.Network.campaign;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CampaignService {
	private final CampaignRepository campaignRepository;

    public Campaign createCampaign(Campaign campaign) {
        if (campaignRepository.existsByTitle(campaign.getTitle())) {
            throw new IllegalStateException("A campaign with this title already exists.");
        }
        return campaignRepository.save(campaign);
    }

    public Campaign updateCampaign(Long id, Campaign campaignDetails) {
        Campaign existingCampaign = campaignRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Campaign not found with id: " + id));

        if (!existingCampaign.getTitle().equals(campaignDetails.getTitle()) &&
                campaignRepository.existsByTitle(campaignDetails.getTitle())) {
            throw new IllegalStateException("A campaign with this title already exists.");
        }
        existingCampaign.setDescription(campaignDetails.getDescription());
        existingCampaign.setShortDescription(campaignDetails.getShortDescription());
        existingCampaign.setDescription(campaignDetails.getDescription());
        return campaignRepository.save(existingCampaign);
    }

    public Object getAllCampaigns() {
        return campaignRepository.findAll();
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
}
