package app.brunosantos.poc.promptresponsegenerator.service;

import app.brunosantos.poc.promptresponsegenerator.service.PromptService;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.anyString;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PromptServiceTest {

    @Mock
    private OpenAiChatModel openAiChatModel;

    @InjectMocks
    private PromptService promptService;

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    void shouldReturnGeneratedText() {
        // Arrange
        String prompt = "What is AI?";
        String expectedResponse = "AI stands for Artificial Intelligence.";
        given(openAiChatModel.generate(anyString())).willReturn(expectedResponse);

        // Act
        String actualResponse = promptService.generateResponse(prompt);
        assertEquals(expectedResponse, actualResponse);
    }
}