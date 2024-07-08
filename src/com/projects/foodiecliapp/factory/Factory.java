package com.projects.foodiecliapp.factory;

import com.projects.foodiecliapp.controller.CustomerController;
import com.projects.foodiecliapp.controller.DishController;
import com.projects.foodiecliapp.repository.CustomerRepositoryImpl;
import com.projects.foodiecliapp.repository.DishRepositoryImpl;
import com.projects.foodiecliapp.service.CustomerServiceImpl;
import com.projects.foodiecliapp.service.DishServiceImpl;
import com.projects.foodiecliapp.util.CsvReader;

public class Factory {

    public static CsvReader getCsvReader(){ return Holder.csvReader; }

    public static CustomerRepositoryImpl getCustomerRepository(){
        return Holder.customerRepository;
    }
    public static CustomerServiceImpl getCustomerService(){
        return Holder.customerService;
    }
    public static CustomerController getCustomerController(){
        return Holder.customerController;
    }

    public static DishRepositoryImpl getDishRepository(){ return Holder.dishRepository;}
    public static DishServiceImpl getDishService(){ return Holder.dishService;}
    public static DishController getDishController(){ return Holder.dishController;}


    private static class Holder{

        private static final CsvReader csvReader = new CsvReader();

        private static final CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();
        private static final CustomerServiceImpl customerService = new CustomerServiceImpl(customerRepository);
        private static final CustomerController customerController = new CustomerController(customerService);

        private static final DishRepositoryImpl dishRepository = new DishRepositoryImpl();
        private static final DishServiceImpl dishService = new DishServiceImpl(dishRepository);
        private static final DishController dishController = new DishController(dishService);
    }
}


