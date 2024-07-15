package com.projects.foodiecliapp.repository;

import com.projects.foodiecliapp.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepositoryImpl implements OrderRepository{

    List<Order> orderList;

    public OrderRepositoryImpl() {
        this.orderList = new ArrayList<>();
    }

    @Override
    public List<Order> getOrdersList() {
        return orderList;
    }

    @Override
    public Order save(Order order) {
        this.orderList.add(order);
        return order;
    }

    @Override
    public Optional<Order> getOrderById(String Id) {
        return this.orderList.stream().filter(order -> order.getId().equals(Id)).findFirst();
    }
}
