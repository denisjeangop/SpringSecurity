package com.example.controller;

import com.example.model.UserEntity;
import com.example.security.CustomSecurityUser;
import com.example.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    AdminServiceImpl adminService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal CustomSecurityUser user, ModelMap modelMap) {
        System.out.println(user);
        modelMap.addAttribute(user);
        return "dashboard";
    }

    @GetMapping("/admin")
    public String admin(ModelMap modelMap) {
        modelMap.addAttribute("users", adminService.getAllUsers());
        return "admin";
    }
}