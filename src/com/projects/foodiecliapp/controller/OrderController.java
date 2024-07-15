package com.projects.foodiecliapp.controller;

import com.projects.foodiecliapp.exceptions.OrderExistsException;
import com.projects.foodiecliapp.exceptions.OrderNotFoundException;
import com.projects.foodiecliapp.model.Order;
import com.projects.foodiecliapp.service.OrderServiceImpl;

import java.util.List;

public class OrderController {
    private OrderServiceImpl orderService;

    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    public List<Order> getOrdersList(){
        return this.orderService.getOrdersList();
    }

    public Order getOrderById(String Id) throws OrderNotFoundException {
        return this.orderService.getOrderById(Id);
    }

    public Order saveOrder(Order order) throws OrderExistsException {
        return this.orderService.save(order);
    }

}
