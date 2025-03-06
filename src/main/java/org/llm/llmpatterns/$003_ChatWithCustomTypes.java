package org.llm.llmpatterns;

import org.llm.openai.GenerativeAIDriverManager;
import org.llm.openai.impl.google.GoogleAIFactory;
import org.llm.openai.model.ChatRequest;

import java.util.List;
import java.util.Map;

public class $003_ChatWithCustomTypes {
    public static void main(String[] args) {
        ServiceLoader.load();

        Map<String, Object> properties = Map.of("apiKey", System.getenv("gemma_key"));
        var service = GenerativeAIDriverManager.create(GoogleAIFactory.NAME, "https://generativelanguage.googleapis.com", properties);

        var prompt = """
                Top 5 Country by GPD. Reply in JSON format
                Example:
                {
                "countries":[
                    {"name":"country 1","gdp":gpd , "unit":"trillion or billion etc","rank":rank of country},
                    {"name":"country 2","gdp":gpd , "unit":"trillion or billion etc","rank":rank of country},
                    {"name":"country 3","gdp":gpd , "unit":"trillion or billion etc","rank":rank of country},
                    {"name":"country 4","gdp":gpd , "unit":"trillion or billion etc","rank":rank of country},
                    {"name":"country 5","gdp":gpd , "unit":"trillion or billion etc","rank":rank of country}
                ]
                }
                """;
        var messages = new ChatRequest.ChatMessage("user", prompt);
        var conversation = ChatRequest.create("gemini-2.0-flash", List.of(messages));
        var reply = service.chat(conversation);
        System.out.println(reply.message());
    }
}
