package com.projects.foodiecliapp.repository;

import com.projects.foodiecliapp.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    public List<Customer> getAllCustomers();
    public Customer save(Customer customer);
    public Optional<Customer> getCustomerById(String id);

}
