package com.example.demo.rest.controller;

import com.example.demo.entity.Order;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rest/order")
public class OrderRestController {
    public List<Order> findAll(){
        return null;
    }
    public Order findById(){
        return null;
    }
    public String create(JsonNode jsonNode){
        return null;
    }
}
