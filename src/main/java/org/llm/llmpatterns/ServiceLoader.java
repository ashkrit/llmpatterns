package org.llm.llmpatterns;

import org.llm.openai.impl.anthropic.AnthropicAIFactory;
import org.llm.openai.impl.google.GoogleAIFactory;
import org.llm.openai.impl.groq.GroqFactory;
import org.llm.openai.impl.ollama.OllamaFactory;
import org.llm.openai.impl.openai.OpenAIFactory;

import static org.llm.openai.GenerativeAIDriverManager.registerService;

public class ServiceLoader {



    public static void load() {
        registerService(OpenAIFactory.NAME, new OpenAIFactory());
        registerService(AnthropicAIFactory.NAME, new AnthropicAIFactory());
        registerService(GoogleAIFactory.NAME, new GoogleAIFactory());
        registerService(GroqFactory.NAME, new GroqFactory());
        registerService(OllamaFactory.NAME, new OllamaFactory());
    }
}
