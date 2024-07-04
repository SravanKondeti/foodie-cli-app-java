package com.projects.foodiecliapp.service;

import com.projects.foodiecliapp.exceptions.CustomerExistsException;
import com.projects.foodiecliapp.model.Customer;

public interface CustomerService {

    public Customer save(Customer customer) throws CustomerExistsException;
}
