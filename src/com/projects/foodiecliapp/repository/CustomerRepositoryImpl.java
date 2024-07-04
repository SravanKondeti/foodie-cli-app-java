package com.projects.foodiecliapp.repository;

import com.projects.foodiecliapp.model.Customer;
import com.projects.foodiecliapp.util.CsvReader;

import java.util.List;
import java.util.Optional;

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
    public Customer save(Customer customer) {
        this.customerList.add(customer);
        return customer;
    }

    @Override
    public Optional<Customer> getCustomerById(String id) {

        return this.customerList.stream().filter(customer -> customer.getCustomerId().equals(id)).findFirst();

    }

}
