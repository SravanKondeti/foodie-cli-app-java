package com.projects.foodiecliapp.factory;

import com.projects.foodiecliapp.controller.CustomerController;
import com.projects.foodiecliapp.repository.CustomerRepositoryImpl;
import com.projects.foodiecliapp.service.CustomerServiceImpl;

public class Factory {

    public static CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();
    public static CustomerServiceImpl customerService = new CustomerServiceImpl(customerRepository);
    public static CustomerController customerController = new CustomerController(customerService);
}
