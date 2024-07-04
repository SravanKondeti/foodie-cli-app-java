package com.projects.foodiecliapp.repository;

import com.projects.foodiecliapp.model.Customer;
import com.projects.foodiecliapp.util.CsvReader;

import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository{

    private List<Customer> customerList;

    public CustomerRepositoryImpl() {
        CsvReader csvReader = new CsvReader();
        this.customerList = csvReader.readCustomersFromCsv();
    }

    @Override
    public List<Customer> getAllCustomers() {

        return this.customerList;
    }

    @Override
    public Customer getCustomerById() {

        return null;
    }

}
