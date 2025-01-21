package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProbeController {
    @GetMapping("/")
    public ResponseEntity<String> checkLiveMethod() {
        System.out.println("Live check!!!!");
        return ResponseEntity.ok("Live!!!");
    }
}
