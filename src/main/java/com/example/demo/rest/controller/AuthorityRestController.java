package com.example.demo.rest.controller;

import com.example.demo.entity.Authority;
import com.example.demo.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin("*")
@RestController()
@RequestMapping("/api/rest/authorities")
public class AuthorityRestController {

    @Autowired
    AuthorityService service;

    @GetMapping()
    public List<Authority> findAll(@RequestParam("admin") Optional<Boolean> admin){
        if(admin.orElse(false)){
            return service.findAuthoriesOfAdministrator();
        }
        return service.findAll();
    }
    @PostMapping()
    public Authority create(@RequestBody Authority obj){
        return service.save(obj);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id){
        service.delete(id);
    }
}
