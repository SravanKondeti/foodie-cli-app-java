package com.projects.foodiecliapp.service;

import com.projects.foodiecliapp.exceptions.OrderExistsException;
import com.projects.foodiecliapp.exceptions.OrderNotFoundException;
import com.projects.foodiecliapp.model.Order;
import com.projects.foodiecliapp.repository.OrderRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService{

    private OrderRepositoryImpl orderRepository;

    public OrderServiceImpl(OrderRepositoryImpl orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getOrdersList() {
        return this.orderRepository.getOrdersList();
    }

    @Override
    public Order getOrderById(String Id) throws OrderNotFoundException {
        Optional<Order> orderById = this.orderRepository.getOrderById(Id);
        if(orderById.isEmpty())
            throw new OrderNotFoundException("Order not found with Id : " + Id);
        return orderById.get();
    }

    @Override
    public Order save(Order order) throws OrderExistsException {
        Optional<Order> orderById = this.orderRepository.getOrderById(order.getId());
        if(orderById.isPresent())
            throw new OrderExistsException("Order already exists with Id : " + order.getId());
        return this.orderRepository.save(order);
    }
}
