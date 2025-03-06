package org.llm.llmpatterns;

import org.llm.openai.GenerativeAIDriverManager;
import org.llm.openai.impl.anthropic.AnthropicAIFactory;
import org.llm.openai.impl.google.GoogleAIFactory;
import org.llm.openai.impl.groq.GroqFactory;
import org.llm.openai.impl.ollama.OllamaFactory;
import org.llm.openai.impl.openai.OpenAIFactory;
import org.llm.openai.model.ChatRequest;

import java.util.List;
import java.util.Map;

import static org.llm.openai.GenerativeAIDriverManager.registerService;

public class App {
    public static void main(String[] args) {

        registerService(OpenAIFactory.NAME, new OpenAIFactory());
        registerService(AnthropicAIFactory.NAME, new AnthropicAIFactory());
        registerService(GoogleAIFactory.NAME, new GoogleAIFactory());
        registerService(GroqFactory.NAME, new GroqFactory());
        registerService(OllamaFactory.NAME, new OllamaFactory());

        Map<String, Object> properties = Map.of("apiKey", System.getenv("gemma_key"));
        var service = GenerativeAIDriverManager.create(GoogleAIFactory.NAME, "https://generativelanguage.googleapis.com", properties);


        System.out.println(service);
        var messages = new ChatRequest.ChatMessage("user", "Hello, how are you?");
        var conversation = ChatRequest.create("gemini-2.0-flash", List.of(messages));
        var reply = service.chat(conversation);
        System.out.println(reply.message());
    }
}
