package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/api/v1/remove")
    public ResponseEntity<String> modify(@RequestParam("input") String input) {
        String output = switch(input.length()){
            case 0, 1 -> null;
            case 2 -> "";
            default -> input.substring(1, input.length() - 1);
        };
        return output != null ? ResponseEntity.ok(output) : ResponseEntity.badRequest().build();
    }

}
