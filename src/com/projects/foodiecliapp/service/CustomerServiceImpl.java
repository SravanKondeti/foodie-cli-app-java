package com.projects.foodiecliapp.service;

import com.projects.foodiecliapp.exceptions.CustomerExistsException;
import com.projects.foodiecliapp.model.Customer;
import com.projects.foodiecliapp.repository.CustomerRepositoryImpl;

import java.util.Optional;

public class CustomerServiceImpl implements CustomerService{

    private CustomerRepositoryImpl customerRepository;

    public CustomerServiceImpl(CustomerRepositoryImpl customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) throws CustomerExistsException {
        Optional<Customer> customerById = this.customerRepository.getCustomerById(customer.getCustomerId());
        if(customerById.isPresent())
            throw new CustomerExistsException("Customer already exists with this ID: " + customer.getCustomerId());
        return this.customerRepository.save(customer);
    }
}
