package com.example.demo.rest.controller;

import com.example.demo.entity.Authority;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/rest/authorities")
public class AuthorityRestController {

//    @GetMapping()
//    public List<Authority> getAll(){
//        return null;
//    }
    @PostMapping()
    public Authority create(@RequestBody Authority obj){
        return null;
    }

    @DeleteMapping("{id}")
    public void delete(){

    }
}
