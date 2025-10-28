package Nat20.Network.requests;

import Nat20.Network.players.PlayerService;
import Nat20.Network.campaign.CampaignService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
@RequiredArgsConstructor

public class RequestsController {
    private final RequestsService requestsService;
    private final CampaignService campaignService;
    private final PlayerService playerService;
    
    @PostMapping
    public ResponseEntity<Requests> createRequest(@Valid @RequestBody Requests request) {
        return ResponseEntity.ok(requestsService.createRequest(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Requests> updateRequest(@PathVariable Long id, @Valid @RequestBody Requests requestDetails) {
        return ResponseEntity.ok(requestsService.updateRequest(id, requestDetails));
    }

    @PostMapping("/{id}/cancel")
    public ResponseEntity<Void> cancelRequest(@PathVariable Long id) {
        requestsService.cancelRequest(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/player/{playerId}")
    public ResponseEntity<List<Requests>> getCustomerRequests(@PathVariable Long playerId) {
        return ResponseEntity.ok(requestsService.getActiveRequestsByPlayer(playerService.getPlayerById(playerId)));
    }

    @GetMapping("/campaign/{campaignID}")
    public ResponseEntity<List<Requests>> getCampaignRequests(@PathVariable Long campaignID) {
        return ResponseEntity.ok(requestsService.getRequestsByCampaign(campaignService.getCampaignById(campaignID)));
    }
}
