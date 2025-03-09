# Spring Cloud Gateway - Simple Routing Example

This project demonstrates how to configure a simple **Spring Cloud Gateway** to route requests to the **http-response-simulator** service, simulating HTTP responses for testing purposes. The gateway will forward requests to various endpoints based on the route configuration.

## Functionality

This project now includes the following routes:

1. GET `/simulate/get`: Routes to `http://localhost:9001/simulate/get`.
2. POST `/simulate/post`: Routes to `http://localhost:9001/simulate/post`.
3. GET `/status`: Routes to `http://localhost:9001/status`.
These endpoints simulate different HTTP responses based on the configuration in the http-response-simulator service.

### Flow:
1. The Spring Cloud Gateway receives a request for any of the configured paths (`/simulate/get`, `/simulate/post`, `/status`).
2. The gateway redirects the request to the http-response-simulator service running on `http://localhost:9001`.
3. The **http-response-simulator** service generates the appropriate response based on the configured simulation logic.
4. The **Spring Cloud Gateway** sends the response back to the client.

## Prerequisites

- Java 17 or higher
- Maven 3.x or higher
- Spring Boot 3.x
- Spring Cloud Gateway
- Docker and Docker Compose installed

## Dockerized Setup

This project includes a docker-compose.yml file to orchestrate the execution of both the Spring Cloud Gateway and the http-response-simulator service.

### Running the Project with Docker

1. Clone the repository:
     
	```bash
	git clone https://github.com/brunosantoslab/poc-lab.git
	cd your-project-directory```
	
2. Build the Docker images and start the containers:
  
    ```bash
    docker-compose up --build```
	
3. This will start both the Spring Cloud Gateway on port 8080 and the http-response-simulator on port 9001.

## Testing the Endpoints
Once the services are up and running, you can test the routing and simulation with the following requests.

1. GET `/simulate/get`
   This route will forward the GET request to `http://localhost:9001/simulate/get`.

   Example using curl: ```curl http://localhost:8080/simulate/get```.
   Or, in Postman, send a GET request to `http://localhost:8080/simulate/get`.

2. POST `/simulate/post`
   This route will forward the POST request to `http://localhost:9001/simulate/post`.

   Example using curl: ```curl -X POST http://localhost:8080/simulate/post -d '{"key":"value"}' -H "Content-Type: application/json"```.
   Or, in Postman, send a POST request to `http://localhost:8080/simulate/post` with a JSON body.

3. GET `/status`
   This route will forward the GET request to `http://localhost:9001/status`.

   Example using curl: ```curl http://localhost:8080/status```.
   Or, in Postman, send a GET request to `http://localhost:8080/status`.

## Project Configuration

### Dependencies in `pom.xml`

The `pom.xml` contains the necessary dependencies for **Spring Boot** and **Spring Cloud Gateway**.

```xml
<dependencies>
    <!-- Spring Cloud Gateway -->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-gateway</artifactId>
    </dependency>

    <!-- Spring Boot Web (to allow the gateway to listen for HTTP requests) -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>```

##Troubleshooting

1. If you encounter any issues, make sure both services are running by checking the logs with: ```docker-compose logs```

2. Ensure Docker is properly installed and that you have access to both containers.


