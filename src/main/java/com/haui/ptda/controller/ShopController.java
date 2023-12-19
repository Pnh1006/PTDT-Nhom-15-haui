package com.haui.ptda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopController {

    @GetMapping("/home")
    public String goToShop(){
        return "index";
    }

}
