package com.projects.foodiecliapp.service;

import com.projects.foodiecliapp.exceptions.OrderExistsException;
import com.projects.foodiecliapp.exceptions.OrderNotFoundException;
import com.projects.foodiecliapp.model.Order;

import java.util.List;

public interface OrderService {

    public List<Order> getOrdersList();
    public Order getOrderById(String Id) throws OrderNotFoundException;
    public Order save(Order order) throws OrderExistsException;
}
