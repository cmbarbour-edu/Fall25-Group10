package Nat20.Network.rules;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.util.data.MutableDataSet;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.util.ast.Node;


@Service
@RequiredArgsConstructor
@Transactional
public class RuleService {
    private final RuleRepository ruleRepository;

    public List<Rule> getAllRules() {
        return ruleRepository.findAll();
    }

    public Rule getRule(String index) {
		return ruleRepository.findByIndex(index);
	}

    public String convertMarkdownToHtml(String markdown) {
        // Enable the tables extension
        MutableDataSet options = new MutableDataSet();
        options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create()));

        // Build parser and renderer with the options
        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();

        // Parse and render the Markdown
        Node document = parser.parse(markdown);
        return renderer.render(document);
    }

}
