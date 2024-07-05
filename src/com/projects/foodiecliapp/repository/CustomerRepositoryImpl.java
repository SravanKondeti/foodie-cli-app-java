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

    @Override
    public Optional<Customer> getCustomerByEmail(String email) {
        return this.customerList.stream().filter(customer -> customer.getEmail().equals(email)).findFirst();
    }

    @Override
    public Customer updateCustomer(Customer customerToBeUpdated) {

        Optional<Customer> updateCustomer = this.customerList.stream().filter(customer -> customer.getCustomerId().equals(customerToBeUpdated.getCustomerId()))
                .findFirst()
                .map(customer -> {
                        customer.setName(customerToBeUpdated.getName())
                                .setEmail(customerToBeUpdated.getEmail())
                                .setPassword(customerToBeUpdated.getPassword());
                        return customer;
                });
        return updateCustomer.orElse(null);
    }

    @Override
    public void deleteCustomer(Customer customerToBeDeleted) {
        this.customerList.remove(customerToBeDeleted);
    }

    @Override
    public Optional<Customer> findEmailAndPassword(String email, String password) {
        return this.customerList.stream().filter(
                customer -> customer.getEmail().equalsIgnoreCase(email)
                        && customer.getPassword().equals(password))
                .findFirst();
    }

}
