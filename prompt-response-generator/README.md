
## Prerequisites

- Java 17 or later
- Maven 3.6 or later
- A valid OpenAI API Key

## Getting Started

1. **Clone the repository:**

    ```bash
    git clone https://github.com/yourusername/prompt-response-generator.git
    cd prompt-response-generator
    ```

2. **Set up environment variables:**

    Ensure that your OpenAI API key is set as an environment variable:

    - On Linux/MacOS:

      ```bash
      export OPENAI_API_KEY="your-openai-api-key"
      ```

    - On Windows (Command Prompt):

      ```cmd
      set OPENAI_API_KEY=your-openai-api-key
      ```

    - On Windows (PowerShell):

      ```powershell
      $env:OPENAI_API_KEY="your-openai-api-key"
      ```

    Replace `"your-openai-api-key"` with your actual OpenAI API key.

3. **Run the application:**

    ```bash
    ./mvnw spring-boot:run
    ```

    The application will start at `http://localhost:8080`.

## API Usage

### Endpoint

- **URL:** `/api/v1/prompt`
- **Method:** `POST`
- **Content-Type:** `application/json`
- **Request Body:** A JSON object with a `prompt` field.

### Example Request

```bash
curl -X POST http://localhost:8080/api/v1/prompt \
    -H "Content-Type: application/json" \
    -d '{"prompt": "Explain the concept of microservices."}'
