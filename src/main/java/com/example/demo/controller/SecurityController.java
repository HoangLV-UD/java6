package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
public class SecurityController {
//    @Autowired
//     Logger log;
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
//        log.config("Sai tài khoản hoặc mật khẩu!");
        return "security/login";
    }

    @RequestMapping("/security/logoff/success")
    public String logoffSuccess(Model model){
        model.addAttribute("message", "Bạn đã đăng xuất!");
        return "security/login";
    }

}
