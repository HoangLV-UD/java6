package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class OrderController {
    @RequestMapping("/api/v1/order/checkout")
    public String checkout(){
        return "order/checkout";

    }
    @RequestMapping("/api/v1/order/list")
    public String list(){
        return "order/list";

    }
    @RequestMapping("/api/v1/order/detail/{id}")
    public String detail(){
        return "order/detail";
    }
}
