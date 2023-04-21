package com.example.demo.rest.controller;

import com.example.demo.entity.Role;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/rest/roles")
public class RoleRestController {

    @Autowired
    RoleService service;

    @GetMapping()
    public List<Role> getAll(){
        return service.findAll();
    }
}
