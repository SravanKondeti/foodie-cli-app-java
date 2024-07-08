package com.projects.foodiecliapp.ui;

import com.projects.foodiecliapp.controller.CustomerController;
import com.projects.foodiecliapp.exceptions.CustomerExistsException;
import com.projects.foodiecliapp.exceptions.CustomerNotFoundException;
import com.projects.foodiecliapp.factory.Factory;
import com.projects.foodiecliapp.model.Customer;

import java.util.List;
import java.util.Scanner;

public class CustomerMenu extends Menu{

    private CustomerController customerController;

    public CustomerMenu() {
        this.customerController = Factory.getCustomerController();
    }


    String dashLine = new String(new char[150]).replace('\0', '-');
    @Override
    public void displayMenu() {
        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                displayMenuHeader("WELCOME TO CUSTOMER SECTION");
                System.out.println();
                System.out.println("Please select the option !");
                System.out.println("--------------------------");
                System.out.println("1. Register (New Customer)");
                System.out.println("2. Login  (Existing Customer)");
                System.out.println("3. Search Customer");
                System.out.println("4. Display All Customers ");
                System.out.println("5. Update Customer");
                System.out.println("6. Delete Customer");
                System.out.println("7. Exit");

                System.out.println("Please enter your choice (1-7)");

                int input = scanner.nextInt();
                switch (input) {
                    case 1 -> customerRegisterForm();
                    case 2 -> customerLoginForm();
                    case 3 -> customerSearchForm();
                    case 4 -> displayAllCustomers();
                    case 5 -> customerUpdateForm();
                    case 6 -> deleteCustomerForm();
                    case 7 -> {
                        System.out.println("Thank you , See you again !");
                        super.displayMenu();
                    }
                    default -> System.out.println("Invalid Input. Please enter the valid input from(1-7)");

                }
            }
        } catch (Exception e) {
            System.out.println("Some internal error occurred. Please try again !");
            displayMenu();
        }
    }

    private void deleteCustomerForm() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details to delete the Customer\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            customerController.deleteCustomer(id);
            System.out.println("Customer Deleted Successfully");
        } catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());
            displayMenu();
        }
    }

    private void customerUpdateForm() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please Update entering the following details\n");
            System.out.println("Enter Your Id");
            String id = scanner.nextLine();
            System.out.println("Enter Name");
            String name = scanner.nextLine();
            System.out.println("Enter E-mail");
            String email = scanner.nextLine();
            System.out.println("Enter Password");
            String password = scanner.nextLine();
            Customer customer = new Customer();
            customer.setId(id)
                    .setName(name)
                    .setEmail(email)
                    .setPassword(password);

            Customer updatedCustomer = customerController.updateCustomer(customer);
            System.out.println("Customer Updated Successfully");
            displayCustomerDetails(updatedCustomer);

        } catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Some internal error occurred. Please try again !");
            customerUpdateForm();
        }
    }

    private void displayAllCustomers() {
        List<Customer> customerList = this.customerController.getCustomersList();
        displayMenuHeader("Customers");
        System.out.printf("%-10s %-30s %-80s %-30s\n","Id","Name","Email", "Password");
        System.out.println(dashLine);
       /* customerList.forEach(customer -> {
            System.out.printf("%-10s %-30s %-80s %-30s\n",customer.getCustomerId(),customer.getName(), customer.getEmail(), "*".repeat(customer.getPassword().length()));
        }); */
        customerList.forEach(this::displayCustomerDetails);
    }

    private void customerSearchForm() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details to search for Customer\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            Customer customer = customerController.getCustomerById(id);
            displayCustomerDetails(customer);
        } catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());
            displayMenu();
        }
    }

    private void customerLoginForm() {
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please login entering the following details\n");
            System.out.println("Enter E-mail");
            String email = scanner.nextLine();
            System.out.println("Enter Password");
            String password = scanner.nextLine();
            Customer existingCustomer = this.customerController.validatCustomerLogin(email, password);
            System.out.println("Login Success :");
            System.out.println("Welcome Mr : " + existingCustomer.getName());
        }catch (Exception e){
            System.out.println(e.getMessage());
            displayMenu();
        }
    }

    private void customerRegisterForm() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please register entering the following details\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            System.out.println("Enter Name");
            String name = scanner.nextLine();
            System.out.println("Enter E-mail");
            String email = scanner.nextLine();
        /*Console console = System.console();
        System.out.println("console : " + console);
        char[] passwordArray = console.readPassword("Enter Password (invisible)");
        String password = String.valueOf(passwordArray);*/
            System.out.println("Enter Password");
            String password = scanner.nextLine();
            // System.out.println("Id : " + id + " , Name : " + name + " , E-mail :  " + email + ", Password :" + password);
            Customer customer = new Customer();
            customer.setId(id)
                    .setName(name)
                    .setEmail(email)
                    .setPassword(password);

            Customer savedCustomer = customerController.save(customer);
            System.out.println("Customer Registration Successful");
            displayCustomerDetails(savedCustomer);
        } catch (CustomerExistsException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Some internal error occurred. Please try again !");
            customerRegisterForm();
        }
    }

    public void displayCustomerDetails(Customer customer) {
        displayMenuHeader("Customer Details");
        System.out.printf("%-10s %-30s %-80s %-30s\n", "Id", "Name", "E-mail", "Password");
        printDashLine();
        System.out.printf("%-10s %-30s %-80s %-30s\n", customer.getCustomerId(), customer.getName(), customer.getEmail(), "*".repeat(customer.getPassword().length()));
    }

}
