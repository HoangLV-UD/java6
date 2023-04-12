package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShoppingCartController {
    @RequestMapping("/api/v1/cart/view")
    public String view(){
        return "cart/view";

    }

    @FunctionalInterface

    public interface Demo4Inter{

        void m1(int x);

    }
    Demo4Inter o4 = x -> System.out.println(x);
    Demo4Inter o1 = new Demo4Inter() { @Override public void m1(int x) {} };
    Demo4Inter o3 = x -> {};
    Demo4Inter o2 = new Demo4Inter() { @Override public void m1(int x) {} public void m2() {} };
}
