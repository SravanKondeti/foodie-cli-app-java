package com.projects.foodiecliapp.factory;

import com.projects.foodiecliapp.controller.CustomerController;
import com.projects.foodiecliapp.repository.CustomerRepositoryImpl;
import com.projects.foodiecliapp.service.CustomerServiceImpl;

public class Factory {

    public static CustomerRepositoryImpl getCustomerRepository(){
        return Holder.customerRepository;
    }
    public static CustomerServiceImpl getCustomerService(){
        return Holder.customerService;
    }
    public static CustomerController getCustomerController(){
        return Holder.customerController;
    }

    private static class Holder{
        private static final CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();
        private static final CustomerServiceImpl customerService = new CustomerServiceImpl(customerRepository);
        private static final CustomerController customerController = new CustomerController(customerService);
    }
}


