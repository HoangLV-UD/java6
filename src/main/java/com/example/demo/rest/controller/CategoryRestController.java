package com.example.demo.rest.controller;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rest/category")
public class CategoryRestController {
    @Autowired
    CategoryService service;
    @GetMapping()
    public List<Category> getAll(){

        return service.findAll();
    }
}
