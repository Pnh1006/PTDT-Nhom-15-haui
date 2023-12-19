package com.haui.ptda.controller;

import com.haui.ptda.response.PageProduct;
import com.haui.ptda.response.ProductResponse;
import com.haui.ptda.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShopController {
    private final ProductService productService;

    public ShopController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/home")
    public String goToShop(){
        return "home";
    }

    @GetMapping("/shop")
    public String getProducts(@RequestParam int page, Model model){
        PageProduct data =  productService.showListProduct(page);
        model.addAttribute("data", data);
        return "shop";
    }

    @GetMapping("/product")
    public String getProductDetail(@RequestParam int id, Model model){
        ProductResponse response = productService.getProductDetail(id);
        model.addAttribute("product", response);
        return "product-detail";
    }

}
