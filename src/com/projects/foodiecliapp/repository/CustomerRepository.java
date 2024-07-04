package com.projects.foodiecliapp.repository;

import com.projects.foodiecliapp.model.Customer;

import java.util.List;

public interface CustomerRepository {

    public List<Customer> getAllCustomers();
    public Customer getCustomerById();

}
