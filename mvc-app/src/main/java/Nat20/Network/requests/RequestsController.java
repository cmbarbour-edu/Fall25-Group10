package Nat20.Network.requests;

import Nat20.Network.players.PlayerService;
import Nat20.Network.campaign.CampaignService;
import Nat20.Network.dungeonMaster.DM;
import Nat20.Network.dungeonMaster.DMService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
@RequiredArgsConstructor

public class RequestsController {
    private final RequestsService requestsService;
    private final CampaignService campaignService;
    private final PlayerService playerService;
    private final DMService dmService;
    
    /*
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
    */

    @GetMapping("/DMs/{dmID}/requests")
    public Object getDMRequests(@PathVariable Long dmID, Model model) {
        DM dm = dmService.getDMById(dmID);
        model.addAttribute("DM", dm);
        model.addAttribute("requestList", requestsService.getRequestsByDM(dm));
        model.addAttribute("Title", "DM Requests:");
        return "dm-request-list";
    }

    @GetMapping("/DMs/{dmID}/requests/{requestID}/accept")
    public Object acceptRequest(@PathVariable Long dmID, @PathVariable Long requestID, Model model) {
        DM dm = dmService.getDMById(dmID);
        if (dm == requestsService.getRequestById(requestID).getCampaign().getDm()) {
            requestsService.acceptRequest(requestID);
            return "redirect:/DMs/" + dmID + "/requests";
        }
        else return "redirect:/DMs/" + dmID + "/home";
    }

    @GetMapping("/DMs/{dmID}/requests/{requestID}/reject")
    public Object rejectRequest(@PathVariable Long dmID, @PathVariable Long requestID, Model model) {
        DM dm = dmService.getDMById(dmID);
        if (dm == requestsService.getRequestById(requestID).getCampaign().getDm()) {
            requestsService.rejectRequest(requestID);
            return "redirect:/DMs/" + dmID + "/requests";
        }
        else return "redirect:/DMs/" + dmID + "/home";
    }
}
