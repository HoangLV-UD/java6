package com.example.demo.service.impl;

import com.example.demo.dao.OrderDao;
import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderDao dao;
    @Override
    public List<Order> findAll() {
        return dao.findAll();
    }

    @Override
    public Order findById(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public String create(JsonNode jsonNode) {

//        return dao.save(jsonNode);
        return null;
    }
}
