package Nat20.Network.dungeonMaster;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/DMs")
@RequiredArgsConstructor
public class DMController {
    private final DMService dmService;
    
    @GetMapping("/createForm")
    public Object showCreateDmForm(Model model) {
        DM dm = new DM();
        model.addAttribute("DM", dm);
        model.addAttribute("title", "Add a new DM");
        return "dm-create";
    }

    @PostMapping
    public Object addDm(DM dm) {
        DM newDm = dmService.createDM(dm);
        return "redirect:/DMs/" + newDm.getDmID() + "/home";
    }

    @GetMapping("/{dmID}/update")
    public Object showUpdateForm(@PathVariable Long dmID, Model model) {
        DM dm = dmService.getDMById(dmID);
        model.addAttribute("DM", dm);
        model.addAttribute("campaignList", dm.getCampaigns());
        model.addAttribute("title", "Update DM");
        return "dm-update";
    }

    @PostMapping("/{dmID}")
    public Object updateDm(@PathVariable Long dmID, DM dmDetails) {
        dmService.updateDM(dmID, dmDetails);
        return "redirect:/DMs/" + dmID + "/profile";
    }

    @GetMapping("/{dmID}/home")
    public Object getDMsByID(@PathVariable Long dmID, Model model) {
        DM dm = dmService.getDMById(dmID);
        model.addAttribute("DM", dm);
        model.addAttribute("title", "DM:");
        return "dm-home";
    }

    @GetMapping("/{dmID}/delete")
    public Object deleteDm(@PathVariable Long dmID) {
        dmService.deleteDM(dmID);
        return "redirect:/home";
    }

    // DM Profile details
    @GetMapping("/{dmID}/profile")
    public Object viewDm(@PathVariable Long dmID, Model model) {
        DM dm = dmService.getDMById(dmID);
        model.addAttribute("DM", dm);
        model.addAttribute("campaignList", dm.getCampaigns());
        model.addAttribute("Title", "DM:");
        return "dm-profile";
    }
    /*
    // DM Requests
    @GetMapping("/${dmID}/requests")
    public Object viewRequests(@PathVariable Long dmID, Model model) {
        // get requests by dm ID?

        return "dm-requests";
    }
        */
}
