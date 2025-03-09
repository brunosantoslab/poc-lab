# HTTP Response Simulator

This project simulates HTTP responses for testing purposes. 

## Functionality

This project has the following available endpoints:

1. GET `/simulate/get`: Routes to `http://localhost:9001/simulate/get`.
2. POST `/simulate/post`: Routes to `http://localhost:9001/simulate/post`.
3. GET `/status`: Routes to `http://localhost:9001/status`.
These endpoints simulate different HTTP responses based on the configuration in the http-response-simulator service.

## Prerequisites

- Java 17 or higher
- Maven 3.x or higher
- Spring Boot 3.x

## Dockerized Setup

This project includes a docker-compose.yml file to orchestrate the execution of both the Spring Cloud Gateway and the http-response-simulator service.


## Testing the Endpoints
Once the service is up and running, you can test the endpoints with the following requests.

1. GET `http://localhost:9001/simulate/get`.
   Example using curl: ```curl http://localhost:9001/simulate/get```.
   Or, in Postman, send a GET request to `http://localhost:9001/simulate/get`.

2. POST `http://localhost:9001/simulate/post`.
   Example using curl: ```curl -X POST http://localhost:9001/simulate/post -d '{"key":"value"}' -H "Content-Type: application/json"```.
   Or, in Postman, send a POST request to `http://localhost:9001/simulate/post` with a JSON body.

3. GET `http://localhost:9001/status`.
   Example using curl: ```curl http://localhost:9001/status```.
   Or, in Postman, send a GET request to `http://localhost:9001/status`. 