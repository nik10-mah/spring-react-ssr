package com.insonix.JavaService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    // @GetMapping("/")
    // public String hello() {
    //     return "Hello from your Spring Boot application!";
    // }

    @RequestMapping({"/", "/static/**", "/manifest.json", "/favicon.ico", "/logo192.png", "/logo512.png"})
    @ResponseBody
    public ResponseEntity<?> proxyToReactSSR(HttpServletRequest request) {
        String url = "http://localhost:3001" + request.getRequestURI();
        logger.info("Proxying request to: {}", url);
        RestTemplate restTemplate = new RestTemplate();

        // Generic handling for images and binary files
        if (url.matches(".*\\.(png|jpg|jpeg|gif|bmp|ico|svg)$")) {
            ResponseEntity<byte[]> response = restTemplate.getForEntity(url, byte[].class);
            logger.info("Received binary response with status: {}", response.getStatusCode());
            return ResponseEntity.status(response.getStatusCode())
                    .headers(response.getHeaders())
                    .body(response.getBody());
        } else {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            logger.info("Received response with status: {}", response.getStatusCode());
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }
    }
}
