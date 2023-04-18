package com.example.demo.service.impl;


import com.fasterxml.jackson.core.type.TypeReference;
import com.example.demo.dao.OrderDao;
import com.example.demo.dao.OrderDetailDao;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import com.example.demo.service.OrderService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao dao;
    @Autowired
    private OrderDetailDao detailDao;

    @Override
    public List<Order> findAll() {
        return dao.findAll();
    }

    @Override
    public Order findById(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public Order create(JsonNode jsonNode) {
        ObjectMapper mapper = new ObjectMapper();

        Order order = mapper.convertValue(jsonNode, Order.class);
        dao.save(order);
        TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {
        };
        List<OrderDetail> details = mapper.convertValue(jsonNode.get("orderDetails"), type)
                .stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
        detailDao.saveAll(details);

        return order;
    }

    @Override
    public Object findByUsername(String username) {
        return dao.findByUsername(username);
    }
}
