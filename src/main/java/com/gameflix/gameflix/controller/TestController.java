package com.gameflix.gameflix.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/")  //endpoint
    public String viewHomePage() {
        return "Hello World";
    }
}