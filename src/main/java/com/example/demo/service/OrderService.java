package com.example.demo.service;

import com.example.demo.entity.Order;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public interface OrderService {
    List<Order>findAll();

    Order findById(Long id);

    String create(JsonNode jsonNode);
}
