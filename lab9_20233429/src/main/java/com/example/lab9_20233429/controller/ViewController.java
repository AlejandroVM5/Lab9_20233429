package com.example.lab9_20233429.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller

public class ViewController {
    @GetMapping({"/","puzzle"})
    public String index() {
        return "index";
    }
}
