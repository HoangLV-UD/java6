package com.example.demo.rest.controller;

import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rest/order")
public class OrderRestController {
    @Autowired
    OrderService orderService;

    public List<Order> findAll(){
        return null;
    }
    public Order findById(){
        return null;
    }
    @PostMapping()
    public Order create(@RequestBody  JsonNode jsonNode){

        return orderService.create(jsonNode);
    }
}
