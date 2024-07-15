package com.projects.foodiecliapp.repository;

import com.projects.foodiecliapp.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    public List<Order> getOrdersList();
    public Order save(Order order);
    public Optional<Order> getOrderById(String Id);
}
