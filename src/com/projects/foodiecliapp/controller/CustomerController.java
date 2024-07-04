package com.projects.foodiecliapp.controller;

import com.projects.foodiecliapp.exceptions.CustomerExistsException;
import com.projects.foodiecliapp.model.Customer;
import com.projects.foodiecliapp.service.CustomerServiceImpl;

public class CustomerController {

    private CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    public Customer save(Customer customer) throws CustomerExistsException {
        return customerService.save(customer);
    }
}
