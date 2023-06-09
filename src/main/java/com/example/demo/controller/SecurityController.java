package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SecurityController {

    @RequestMapping("/security/login/form")
    public String loginForm(Model model){
        model.addAttribute("message", "Vui lòng đăng nhập");
        System.out.println("aaaa");
        return "security/login";
    }
    @RequestMapping("/security/login/success")
    public String loginSuccess(Model model){
        model.addAttribute("message", "Đăng nhap thành công");
//        log.config("Đăng nhap thành công");
        return "security/login";
    }

    @RequestMapping("/security/unauthoried")
    public String unauthoried(Model model){
        model.addAttribute("message", "Bạn không có quyền truy xuất!");
        return "security/login";
    }

    @RequestMapping("/security/login/error")
    public String loginError(Model model){
        model.addAttribute("message", "Sai tài khoản hoặc mật khẩu!");
        return "security/login";
    }

    @RequestMapping("/security/logoff/success")
    public String logoffSuccess(Model model){
        model.addAttribute("message", "Bạn đã đăng xuất!");
        return "security/login";
    }

}
