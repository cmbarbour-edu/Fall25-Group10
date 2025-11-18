package Nat20.Network;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AppController {
    @GetMapping("/login")
    public Object showLoginForm(Model model) {
        return "login";
    }

    @GetMapping("/home")
    public Object getDMsByID(@PathVariable Long dmID, Model model) {
        return "static-home";
    }
}
