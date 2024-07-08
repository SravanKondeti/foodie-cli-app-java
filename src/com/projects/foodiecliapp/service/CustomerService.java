package com.projects.foodiecliapp.service;

import com.projects.foodiecliapp.exceptions.CustomerExistsException;
import com.projects.foodiecliapp.exceptions.CustomerNotFoundException;
import com.projects.foodiecliapp.model.Customer;

import java.util.List;

public interface CustomerService {

    public Customer save(Customer customer) throws CustomerExistsException;
    public List<Customer> getCustomerList();
    public Customer getCustomerById(String Id) throws CustomerNotFoundException;
    public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;
    public void deleteCustomer(String Id) throws CustomerNotFoundException;
    public Customer validateCustomerLogin(String email, String password) throws CustomerNotFoundException;
    public void setCurrentLoggedInCustomer(Customer customer);
    public Customer getCurrentLoggedInCustomer();
}
