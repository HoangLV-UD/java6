package com.example.demo.rest.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping("{id}")
    public Product updateProduct(@PathVariable("id") Integer id, @RequestBody Product obj){

        return productService.update(obj);
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable("id") Integer id){

         productService.deleteById(id);
    }

    @PostMapping()
    public Product create(@RequestBody Product obj){

        return productService.create(obj);
    }

    @GetMapping()
    public List<Product> getAll(){

        return productService.findAll();
    }
}
