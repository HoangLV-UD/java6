package com.example.demo.rest.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rest/product")
public class ProductRestController {
    @Autowired
    ProductService productService;

    @GetMapping("{id}")
    public Product getOne(@PathVariable("id") Integer id){

        return productService.findById(id);
    }

    @GetMapping()
    public List<Product> getAll(){

        return productService.findAll();
    }
}
