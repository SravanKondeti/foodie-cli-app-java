package com.projects.foodiecliapp.repository;

import com.projects.foodiecliapp.exceptions.CustomerNotFoundException;
import com.projects.foodiecliapp.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    public List<Customer> getAllCustomers();
    public Customer save(Customer customer);
    public Optional<Customer> getCustomerById(String id);
    public Optional<Customer> getCustomerByEmail(String email);
    public Customer updateCustomer(Customer customerToBeUpdated);
    public void deleteCustomer(Customer customerToBeDeleted);
    public Optional<Customer> findEmailAndPassword(String email, String password);

}
