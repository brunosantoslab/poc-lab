package app.brunosantos.poc.promptresponsegenerator.controller;

import app.brunosantos.poc.promptresponsegenerator.service.PromptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/prompt")
public class PromptController {

  private final PromptService promptService;

  public PromptController(PromptService promptService) {
    this.promptService = promptService;
  }

  @PostMapping
  public ResponseEntity<String> generateResponse(@RequestBody String prompt) {
    String response = promptService.generateResponse(prompt);
    return ResponseEntity.ok(response);
  }
}
