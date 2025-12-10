package Nat20.Network.rules;

import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import Nat20.Network.dungeonMaster.DMService;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class RuleController {
    private final RuleService ruleService;
    private final DMService dmService;

    @GetMapping("/DMs/{dmID}/rules")
    public String getRulesList(@PathVariable Long dmID ,Model model) {
        List<Rule> rules = ruleService.getAllRules();
        model.addAttribute("ruleList", rules);
        model.addAttribute("DM", dmService.getDMById(dmID));
        return "dm-rules-list";
    }

    @GetMapping("/DMs/{dmID}/rules/{index}")
    public String getRuleByIndex(@PathVariable Long dmID, @PathVariable String index, Model model) {
        Rule rule = ruleService.getRule(index);
        model.addAttribute("rule", rule);
        model.addAttribute("descHtml", ruleService.convertMarkdownToHtml(rule.getDesc()));
        model.addAttribute("DM", dmService.getDMById(dmID));
        return "dm-rules-details";
    }
}
