package com.haui.ptda.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLoginForm(Model model){
        model.addAttribute("error", false);
        return "login";
    }

    @GetMapping("/login-error")
    public String getLoginFormError(Model model){
        model.addAttribute("error", true);
        return "login";
    }
}
