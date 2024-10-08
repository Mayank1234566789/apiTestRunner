package com.testCase.testCaseRunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Api {

    private static final Logger logger = LoggerFactory.getLogger(Api.class);

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() throws InterruptedException {
        logger.info("Received request for /hello");
        // Introducing delay
        Thread.sleep(3000); // Delay of 3 seconds
        String message = "Hello, World!";
        logger.debug("Response message: {}", message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<String> getUser(@PathVariable String id) throws InterruptedException {
        logger.info("Received request for /user/{}", id);
        // Introducing delay
        Thread.sleep(3500); // Delay of 3.5 seconds
        String response = "User ID: " + id;
        logger.debug("Response message: {}", response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Other methods remain the same

    @GetMapping("/status")
    public ResponseEntity<String> getStatus() throws InterruptedException {
        logger.info("Received request for /status");
        // Introducing delay
        Thread.sleep(4000); // Delay of 4 seconds
        String status = "Status: Up and running!";
        logger.debug("Response message: {}", status);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
    
    // Example delay in add and subtract methods
    @GetMapping("/add/{num1}/{num2}")
    public ResponseEntity<Integer> addNumbers(@PathVariable int num1, @PathVariable int num2) throws InterruptedException {
        logger.info("Received request for /add/{}/{}", num1, num2);
        // Introducing delay
        Thread.sleep(3000); // Delay of 3 seconds
        int sum = num1 + num2;
        logger.debug("Computed sum: {}", sum);
        return new ResponseEntity<>(sum, HttpStatus.OK);
    }

    @GetMapping("/subtract/{num1}/{num2}")
    public ResponseEntity<Integer> subtractNumbers(@PathVariable int num1, @PathVariable int num2) throws InterruptedException {
        logger.info("Received request for /subtract/{}/{}", num1, num2);
        // Introducing delay
        Thread.sleep(3500); // Delay of 3.5 seconds
        int difference = num1 - num2;
        logger.debug("Computed difference: {}", difference);
        return new ResponseEntity<>(difference, HttpStatus.OK);
    }
}
