package Nat20.Network;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Nat20.Network.dungeonMaster.DM;
import Nat20.Network.dungeonMaster.DMService;
import Nat20.Network.players.Player;
import Nat20.Network.players.PlayerService;
import Nat20.Network.sysadmin.Sysadmin;
import Nat20.Network.sysadmin.SysadminService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class AppController {
    private final PlayerService playerService;
    private final DMService dmService;
    private final SysadminService adminService;
    
    @GetMapping("/login")
    public Object showLoginForm(Model model) {
        return "login";
    }

    @PostMapping("/login")
	public String loginUser(
		@RequestParam String email,
		@RequestParam String password,
		@RequestParam String role,
		Model model
	) {
		switch (role) {

			case "PLAYER": {
				Player player = playerService.getPlayerByEmail(email);
				if (player == null || !player.getPassword().equals(password)) {
					model.addAttribute("error", "Invalid player credentials.");
					model.addAttribute("email", email);
					return "login";
				}
				return "redirect:/players/" + player.getPlayerID() + "/home";
			}
			case "DM": {
				DM dm = dmService.getDMByEmail(email);
				if (dm == null || !dm.getPassword().equals(password)) {
					model.addAttribute("error", "Invalid DM credentials.");
					model.addAttribute("email", email);
					return "login";
				}
				return "redirect:/DMs/" + dm.getDmID() + "/home";
			}
			case "ADMIN": {
				Sysadmin admin = adminService.getSysadminByEmail(email);
				if (admin == null || !admin.getPassword().equals(password)) {
					model.addAttribute("error", "Invalid admin credentials.");
					model.addAttribute("email", email);
					return "login";
				}
				return "redirect:/admin/home"; // Update with admin homepage
			}
            default:
				model.addAttribute("error", "Unknown login role.");
				return "login";
		}
    }

    @GetMapping("/home")
    public Object showHome(Model model) {
        return "static-home";
    }

    @GetMapping("/signup")
    public Object showSignupOptions(Model model) {
        return "signup-options";
    }
}
