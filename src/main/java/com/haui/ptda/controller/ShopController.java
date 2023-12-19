package com.haui.ptda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShopController {

    @GetMapping("/home")
    public String goToShop(){
        return "home";
    }

    @GetMapping("/shop")
    public String getProducts(){
        return "shop";
    }

    @GetMapping("/product")
    public String getProductDetail(){
        return "product-detail";
    }

}
