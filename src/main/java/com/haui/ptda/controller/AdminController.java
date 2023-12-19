package com.haui.ptda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/manage")
    public String getHome(){
        return "admin";
    }
}
