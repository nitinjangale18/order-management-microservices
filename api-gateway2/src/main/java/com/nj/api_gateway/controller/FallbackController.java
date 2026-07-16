package com.nj.api_gateway.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @RequestMapping("/fallback/order")
    public ResponseEntity<Map<String, String>> orderFallback() {
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(Map.of(
                        "status", "503",
                        "message", "Order Service is temporarily unavailable"
                ));
    }

    @RequestMapping("/fallback/inventory")
    public ResponseEntity<Map<String, String>> inventoryFallback() {
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(Map.of(
                        "status", "503",
                        "message", "Inventory Service is temporarily unavailable"
                ));
    }
}