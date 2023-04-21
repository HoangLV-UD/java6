package com.example.demo.rest.controller;

import com.example.demo.entity.Account;
import com.example.demo.entity.Role;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/rest/accounts")
public class AccountRestController {
    @Autowired
    AccountService service;
    @GetMapping()
    public List<Account> getAll(@RequestParam("admin")Optional<Boolean>admin){
        if(admin.orElse(false)){
            return service.getAdministrators();
        }
        return service.findAll();
    }


}
