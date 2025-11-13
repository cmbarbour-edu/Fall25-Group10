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
        model.addAttribute("dm", dm);
        model.addAttribute("title", "Add a new DM");
        return "dm-create";
    }

    @PostMapping
    public Object addDm(DM dm) {
        DM newDm = dmService.createDM(dm);
        return "redirect:/DMs/" + newDm.getDmID();
    }

    @GetMapping("/updateForm/{dmID}")
    public Object showUpdateForm(@PathVariable Long dmID, Model model) {
        DM dm = dmService.getDMById(dmID);
        model.addAttribute("DM", dm);
        model.addAttribute("title", "Update DM");
        return "dm-update";
    }

    @PostMapping("/{DmID}")
    public Object updateDm(@PathVariable Long dmID, DM dmDetails) {
        dmService.updateDM(dmID, dmDetails);
        return "redirect:/DMs/" + dmID;
    }

    @GetMapping("/{DmID}")
    public Object getDMsByID(@PathVariable Long DmID, Model model) {
        model.addAttribute("DM", dmService.getDMById(DmID));
        model.addAttribute("title", "DM:");
        return "dm-details";
    }

    @GetMapping("/{DmID}/delete")
    public Object deleteDm(@PathVariable Long dmID) {
        dmService.deleteDM(dmID);
        return "redirect:/home";
    }
}
