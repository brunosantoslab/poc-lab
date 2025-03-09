package app.brunosantos.httpresponsesimulator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/simulate")
public class HttpResponseSimulatorController {

    @GetMapping("/get")
    public ResponseEntity<String> getSimulatedResponse(
            @RequestParam(value = "status", defaultValue = "200") int status,
            @RequestParam(value = "message", defaultValue = "OK") String message) {

        HttpStatus httpStatus = HttpStatus.valueOf(status);
        return new ResponseEntity<>(message, httpStatus);
    }

    @PostMapping("/post")
    public ResponseEntity<String> postSimulatedResponse(
        @RequestParam(value = "status", defaultValue = "200") int status,
        @RequestParam(value = "message", defaultValue = "Created") String message) {

        HttpStatus httpStatus = HttpStatus.valueOf(status);
        return new ResponseEntity<>(message, httpStatus);
    }

    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return ResponseEntity.ok("Service is running");
    }
}
