package Nat20.Network.requests;

import Nat20.Network.players.*;
import Nat20.Network.dungeonMaster.*;
import Nat20.Network.campaign.*;

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

    public List<Requests> getActiveRequestsByPlayer(Player player) {
        return requestsRepo.findByPlayerAndActive(player, true);
    }

    public List<Requests> getRequestsByCampaign(Campaign campaign) {
        return requestsRepo.findByCampaign(campaign);
    }

    public List<Requests> getRequestsByDM(DM dm) {
        return requestsRepo.findByDM(dm);
    }
}
