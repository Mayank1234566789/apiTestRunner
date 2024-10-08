package com.testCase.testCaseRunner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static java.time.Duration.ofSeconds;

public class ApiTest {

    private Api api;

    @BeforeEach
    public void setUp() {
        api = new Api();
    }

    @Test
    public void testSayHello() {
        assertTimeout(ofSeconds(4), () -> {
            ResponseEntity<String> response = api.sayHello();
            assertEquals("Hello, World!", response.getBody());
            assertEquals(200, response.getStatusCodeValue());
        });
    }

    @Test
    public void testGetUser() {
        assertTimeout(ofSeconds(5), () -> {
            ResponseEntity<String> response = api.getUser("1");
            assertEquals("User ID: 1", response.getBody());
            assertEquals(200, response.getStatusCodeValue());
        });
    }

   /* @Test
    public void testCreateUser() {
        ResponseEntity<String> response = api.createUser("John Doe");
        assertEquals("User created: John Doe", response.getBody());
        assertEquals(201, response.getStatusCodeValue());
    }*/

    @Test
    public void testGetStatus() {
        assertTimeout(ofSeconds(5), () -> {
            ResponseEntity<String> response = api.getStatus();
            assertEquals("Status: Up and running!", response.getBody());
            assertEquals(200, response.getStatusCodeValue());
        });
    }

    @Test
    public void testAddNumbers() {
        assertTimeout(ofSeconds(4), () -> {
            ResponseEntity<Integer> response = api.addNumbers(5, 3);
            assertEquals(8, response.getBody());
            assertEquals(200, response.getStatusCodeValue());
        });
    }

    @Test
    public void testSubtractNumbers() {
        assertTimeout(ofSeconds(5), () -> {
            ResponseEntity<Integer> response = api.subtractNumbers(5, 3);
            assertEquals(2, response.getBody());
            assertEquals(200, response.getStatusCodeValue());
        });
    }
}
