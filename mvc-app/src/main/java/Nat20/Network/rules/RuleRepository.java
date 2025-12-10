package Nat20.Network.rules;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Repository
public class RuleRepository {

	private final OkHttpClient client;
	private final ObjectMapper objectMapper;

	public RuleRepository() {
		this.client = new OkHttpClient();
		this.objectMapper = new ObjectMapper();
	}

    public List<Rule> findAll() {
        String url = "https://www.dnd5eapi.co/api/2014/rule-sections/";

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("Accept", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new RuntimeException("API call failed: " + response.code());
            }

            String body = response.body().string();
            JsonNode root = objectMapper.readTree(body);
            JsonNode results = root.get("results");

            List<Rule> rules = new ArrayList<>();
            for (JsonNode node : results) {
                Rule rule = new Rule();
                rule.setIndex(node.get("index").asText());
                rule.setName(node.get("name").asText());
                rule.setUrl(node.get("url").asText());
                rules.add(rule);
            }

            return rules;

        } catch (IOException e) {
            throw new RuntimeException("API call failed", e);
        }
    }
    
    public Rule findByIndex(String index) {
        index = index.trim().toLowerCase();
        String url = "https://www.dnd5eapi.co/api/2014/rule-sections/" + index;

        Request request = new Request.Builder()
            .url(url)
            .get()
            .addHeader("Accept", "application/json")
            .build();

        try (Response response = client.newCall(request).execute()) {

            if (response == null) {
                throw new RuntimeException("No response returned from API. URL: " + url);
            }

            int code = response.code();
            if (!response.isSuccessful()) {
                String errorBody = "";
                try {
                    errorBody = response.body() != null ? response.body().string() : "null";
                } catch (IOException e) {
                    errorBody = "Failed to read error body: " + e.getMessage();
                }
                throw new RuntimeException("API call failed: HTTP " + code + "\nURL: " + url + "\nResponse body: " + errorBody);
            }

            String body;
            try {
                body = response.body() != null ? response.body().string() : null;
                if (body == null || body.isEmpty()) {
                    throw new RuntimeException("Empty response body from API. URL: " + url);
                }
            } catch (IOException e) {
                throw new RuntimeException("Failed to read response body from API. URL: " + url, e);
            }

            JsonNode node;
            try {
                node = objectMapper.readTree(body);
            } catch (Exception e) {
                throw new RuntimeException("Failed to parse JSON. URL: " + url + "\nResponse body: " + body, e);
            }

            try {
                Rule rule = new Rule();
                rule.setName(node.get("name").asText());
                rule.setIndex(node.get("index").asText());
                rule.setDesc(node.get("desc").asText());
                rule.setUrl(node.get("url").asText());
                rule.setUpdated_at(node.get("updated_at").asText());
                return rule;
            } catch (Exception e) {
                throw new RuntimeException("Failed to map JSON fields to Rule object. JSON: " + body, e);
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed to execute API request. URL: " + url, e);
        }
    }

}
