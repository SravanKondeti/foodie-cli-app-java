package com.projects.foodiecliapp;

import com.projects.foodiecliapp.repository.CustomerRepositoryImpl;
import com.projects.foodiecliapp.util.CsvReader;

public class Main {

    public static void main(String[] args) {
//        CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();
//        System.out.println(customerRepository.getAllCustomers());

        CsvReader csvReader = new CsvReader();
        System.out.println(csvReader.readCustomersFromCsv());
//        csvReader.readDishesFromCsv();
//        csvReader.readRestaurantsFromCsv();

    }
}
