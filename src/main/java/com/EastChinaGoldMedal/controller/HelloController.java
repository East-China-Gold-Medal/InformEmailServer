package com.EastChinaGoldMedal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/HelloWorld")
    public String helloWorld(){
        return "HelloWorld";
    }
}
