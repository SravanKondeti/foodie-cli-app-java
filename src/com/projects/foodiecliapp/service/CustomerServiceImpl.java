package com.projects.foodiecliapp.service;

import com.projects.foodiecliapp.exceptions.CustomerExistsException;
import com.projects.foodiecliapp.exceptions.CustomerNotFoundException;
import com.projects.foodiecliapp.model.Customer;
import com.projects.foodiecliapp.repository.CustomerRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService{

    private CustomerRepositoryImpl customerRepository;
    private Customer currentLoggedInCustomer;

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

    @Override
    public List<Customer> getCustomerList() {
        return customerRepository.getAllCustomers();
    }

    @Override
    public Customer getCustomerById(String Id) throws CustomerNotFoundException {
        Optional<Customer> customerById = this.customerRepository.getCustomerById(Id);
        if(customerById.isEmpty())
            throw new CustomerNotFoundException("Customer already exists with this ID: " + Id);
        return customerById.get();
    }

    @Override
    public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
        Optional<Customer> customerById = this.customerRepository.getCustomerById(customer.getCustomerId());
        if(customerById.isEmpty())
            throw new CustomerNotFoundException("Customer not found with Id : " + customer.getCustomerId());
        return this.customerRepository.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(String Id) throws CustomerNotFoundException {
        Optional<Customer> customerById = this.customerRepository.getCustomerById(Id);
        if(customerById.isEmpty())
            throw new CustomerNotFoundException("Customer not found with Id : " + Id);
        this.customerRepository.deleteCustomer(customerById.get());
    }

    @Override
    public Customer validateCustomerLogin(String email, String password) throws CustomerNotFoundException {
        Optional<Customer> customer = this.customerRepository.findByEmailAndPassword(email, password);
        if(customer.isEmpty())
            throw new CustomerNotFoundException("Invalid Email or Password");
        return customer.get();
    }

    @Override
    public void setCurrentLoggedInCustomer(Customer customer) {
        this.currentLoggedInCustomer = customer;
    }

    @Override
    public Customer getCurrentLoggedInCustomer() {
        return this.currentLoggedInCustomer;
    }

}
