package com.haui.ptda.controller;

import com.haui.ptda.entity.Product;
import com.haui.ptda.request.ProductRequest;
import com.haui.ptda.response.PageProduct;
import com.haui.ptda.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    private final ProductService productService;

    public AdminController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/manage")
    public String getHome(@RequestParam int page, Model model){
        PageProduct data = productService.manageListProduct(page);
        model.addAttribute("data", data);
        return "admin";
    }

    @GetMapping("/create-form")
    public String getCreateForm(){
        return "create-form";
    }

    @GetMapping("/update-form")
    public String getUpdateForm(@RequestParam int id,  Model model){
        Product product = productService.getProduct(id);
        model.addAttribute("product", product);
        return "update-form";
    }

    @GetMapping("/delete-product")
    public String deleteProduct(@RequestParam int id){
        productService.deleteProduct(id);
        return "redirect:manage?page=0";
    }
    @PostMapping("/create-new")
    public String createProduct(@ModelAttribute ProductRequest request, Model model){
        productService.createNewProduct(request);
        return "redirect:manage?page=0";
    }

    @PostMapping("/update-product")
    public String updateProduct(@ModelAttribute ProductRequest request, Model model){
        productService.updateProduct(request);
        return "redirect:manage?page=0";
    }
}
