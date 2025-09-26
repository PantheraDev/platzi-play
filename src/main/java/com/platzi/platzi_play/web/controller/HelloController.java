package com.platzi.platzi_play.web.controller;

import com.platzi.platzi_play.domain.service.PlatziPlayIAService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final String platform;
    private final PlatziPlayIAService aiService;

    public  HelloController(@Value("${spring.application.name}") String platform, PlatziPlayIAService aiService){
        this.platform = platform;
        this.aiService = aiService;
    }

    @GetMapping("/hello")
    public String hello(){
        return this.aiService.generateGreeting(platform);
    }

}