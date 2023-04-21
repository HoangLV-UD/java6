package com.example.demo.rest.controller;

import com.example.demo.entity.Authority;
import com.example.demo.entity.Role;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController("/api/rest/roles")
public class RoleRestController {

    @GetMapping()
    public List<Role> getAll(){
        return null;
    }
}
