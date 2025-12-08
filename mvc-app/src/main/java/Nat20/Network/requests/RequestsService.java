package Nat20.Network.requests;

import Nat20.Network.players.*;
import Nat20.Network.campaign.*;
import Nat20.Network.dungeonMaster.DM;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional

public class RequestsService {
    private final RequestsRepo requestsRepo;

    public Requests createRequest(Requests requests) {
        return requestsRepo.save(requests);
    }

    public Requests updateRequest(Long id, Requests requestDetails) {
        Requests requests = requestsRepo.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Request not found"));

        requests.setType(requestDetails.getType());
        requests.setActive(requestDetails.isActive());

        return requestsRepo.save(requests);
    }

    public void cancelRequest(Long id) {
        Requests requests = requestsRepo.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Request not found"));
        requests.setActive(false);
        requestsRepo.save(requests);
    }

    public void acceptRequest(Long id) {
        Requests requests = requestsRepo.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Request not found"));
        requests.acceptRequest();
        requestsRepo.save(requests);
    }

    public void rejectRequest(Long id) {
        Requests requests = requestsRepo.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Request not found"));
        requests.rejectRequest();
        requestsRepo.save(requests);
    }

    public Requests getRequestById(Long id) {
        return requestsRepo.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Request not found"));
    }

    public List<Requests> getActiveRequestsByPlayer(Player player) {
        return requestsRepo.findByPlayerAndActive(player, true);
    }

    public List<Requests> getRequestsByCampaign(Campaign campaign) {
        return requestsRepo.findByCampaignAndActive(campaign, true);
    }

    public List<Requests> getRequestsByDM(DM dm) {
        List<Requests> requests = new java.util.ArrayList<>();
        for (Campaign campaign : dm.getCampaigns()) {
            requests.addAll(requestsRepo.findByCampaignAndActive(campaign, true));
        }
        return requests;
    }
}
