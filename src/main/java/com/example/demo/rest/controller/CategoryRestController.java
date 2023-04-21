package com.example.demo.rest.controller;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/rest/category")
public class CategoryRestController {
    @Autowired
    CategoryService service;
    @GetMapping()
    public List<Category> getAll(){

        return service.findAll();
    }

    @PostMapping()
    public Category create(@RequestBody Category obj){

        return service.create(obj);
    }
}
