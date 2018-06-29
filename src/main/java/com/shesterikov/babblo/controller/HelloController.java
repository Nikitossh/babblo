package com.shesterikov.babblo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring";
    }

    @RequestMapping("/title")
    public String title() {
        return "Its title page and I want to do it dynamic, NOT static";
    }
}
