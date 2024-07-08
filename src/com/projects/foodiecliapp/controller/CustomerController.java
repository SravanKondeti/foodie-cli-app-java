package com.projects.foodiecliapp.controller;

import com.projects.foodiecliapp.exceptions.CustomerExistsException;
import com.projects.foodiecliapp.exceptions.CustomerNotFoundException;
import com.projects.foodiecliapp.model.Customer;
import com.projects.foodiecliapp.service.CustomerService;
import com.projects.foodiecliapp.service.CustomerServiceImpl;

import java.util.List;

public class CustomerController {

    private CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    public Customer save(Customer customer) throws CustomerExistsException {
        return customerService.save(customer);
    }

    public Customer validatCustomerLogin(String email, String password) throws  CustomerNotFoundException{
        Customer customer = this.customerService.validateCustomerLogin(email, password);
        if(customer != null)
            this.customerService.setCurrentLoggedInCustomer(customer);
        return customer;
    }

    public Customer currentLoggedInCustomer(){
        return this.customerService.getCurrentLoggedInCustomer();
    }
    public List<Customer> getCustomersList(){
        return this.customerService.getCustomerList();
    }

    public Customer getCustomerById(String Id) throws CustomerNotFoundException {
        return this.customerService.getCustomerById(Id);
    }

    public Customer updateCustomer(Customer customer) throws CustomerNotFoundException{
        return this.customerService.updateCustomer(customer);
    }

    public void deleteCustomer(String Id) throws CustomerNotFoundException {
        this.customerService.deleteCustomer(Id);
    }
}
