package app.brunosantos.poc.promptresponsegenerator.service;

import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.stereotype.Service;

@Service
public class PromptService {

  private final OpenAiChatModel openAiChatModel;

  public PromptService(OpenAiChatModel openAiChatModel) {
    this.openAiChatModel = openAiChatModel;
  }

  public String generateResponse(String prompt) {
    return openAiChatModel.generate(prompt);
  }
}
