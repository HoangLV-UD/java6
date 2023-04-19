package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping({"/","/home/index"})
    public String home(){
        return "redirect:/api/v1/product/list";
    }

    @RequestMapping({"/admin","/admin/home/index"})
    public String admin(){
        return "redirect:/assets/admin/index.html";
    }
}
