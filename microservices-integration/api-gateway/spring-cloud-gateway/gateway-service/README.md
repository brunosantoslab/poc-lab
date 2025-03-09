# Spring Cloud Gateway - Simple Routing Example

This project demonstrates how to configure a simple **Spring Cloud Gateway** to redirect a GET request to the endpoint `https://httpbin.org/get` when the URL path is `/hello`.

## Functionality

When you make a request to `http://localhost:8080/hello`, the **Spring Cloud Gateway** will redirect this request to `https://httpbin.org/get`. The response from **httpbin.org** will then be returned as the response for the original request.

### Flow:
1. The gateway receives a request for the path `/hello`.
2. The gateway redirects the request to `https://httpbin.org/get`.
3. **httpbin.org** returns information about the request, such as headers and parameters.
4. The **Spring Cloud Gateway** sends the response back to the client.

## Prerequisites

- Java 17 or higher
- Maven 3.x or higher
- Spring Boot 3.x
- Spring Cloud Gateway

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
</dependencies>
