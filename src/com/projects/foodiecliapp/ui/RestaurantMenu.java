package com.projects.foodiecliapp.ui;

import com.projects.foodiecliapp.controller.RestaurantController;
import com.projects.foodiecliapp.exceptions.RestaurantExistsException;
import com.projects.foodiecliapp.exceptions.RestaurantNotFoundException;
import com.projects.foodiecliapp.factory.Factory;
import com.projects.foodiecliapp.model.Restaurant;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RestaurantMenu extends Menu {
    private RestaurantController restaurantController;

    public RestaurantMenu() {
        this.restaurantController = Factory.getRestaurantController();
    }

    @Override
    public void displayMenu() {
        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                displayMenuHeader("WELCOME TO RESTAURANT SECTION");
                System.out.println();
                System.out.println("Please select the option !");
                System.out.println("--------------------------");
                System.out.println("1. Add New Restaurant");
                System.out.println("2. View All Restaurants");
                System.out.println("3. Search Restaurant");
                System.out.println("4. Update Restaurant ");
                System.out.println("5. Delete Restaurant");
                System.out.println("6. Exit");

                System.out.println("Please enter your choice (1-6)");

                int input = scanner.nextInt();
                switch (input) {
                    case 1 -> newRestaurantForm();
                    case 2 -> displayRestaurants();
                    case 3 -> restaurantSearchForm();
                    case 4 -> restaurantUpdateForm();
                    case 5 -> restaurantDeleteForm();
                    case 6 -> {
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

    private void restaurantDeleteForm() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details to delete the Restaurant\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            restaurantController.deleteRestaurant(id);
            System.out.println("Restaurant Deleted Successfully");
        } catch (RestaurantNotFoundException e) {
            System.out.println(e.getMessage());
            displayMenu();
        }

    }

    private void restaurantUpdateForm() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please Update entering the following details\n");
            System.out.println("Enter Restaurant Id");
            String id = scanner.nextLine();
            System.out.println("Enter Name");
            String name = scanner.nextLine();
            System.out.println("Enter Address");
            String address = scanner.nextLine();
            System.out.println("Enter Menu Dish Items separated by : (D101:D102)");
            String menu = scanner.nextLine();
            Restaurant restaurant = new Restaurant();
            restaurant.setName(name)
                    .setAddress(address)
                    .setMenu(Arrays.asList(menu.split(":")));
            Restaurant updatedRestaurant = this.restaurantController.updateRestaurant(restaurant);
            System.out.println("Restaurant updated successfully!");
            displayRestaurant(updatedRestaurant);
        }catch (RestaurantNotFoundException e){
            e.getMessage();
            restaurantUpdateForm();
        }
    }

    private void restaurantSearchForm() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details to find the Restaurant\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            Restaurant restaurant = this.restaurantController.getRestaurantById(id);
            displayRestaurant(restaurant);
        }catch (RestaurantNotFoundException e){
            e.getMessage();
            displayMenu();
        }
    }

    private void displayRestaurants() {
        List<Restaurant> restaurantList = this.restaurantController.getRestaurantList();
        displayMenuHeader("Restaurants");
        System.out.printf("%-10s %-30s %-80s %-30s\n", "Id", "Name", "Address", "Menu Items");
        printDashLine();
        restaurantList.forEach(restaurant -> {
            System.out.printf("%-10s %-30s %-80s %-30s\n", restaurant.getId(), restaurant.getName(), restaurant.getAddress(), String.join(":", restaurant.getMenu()));
        });
    }

    private void newRestaurantForm() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            System.out.println("Enter Name");
            String name = scanner.nextLine();
            System.out.println("Enter Address");
            String address = scanner.nextLine();
            System.out.println("Enter Dishes for Menu separated by : (D010:D009)");
            String menu = scanner.nextLine();
            Restaurant restaurant = new Restaurant();
            restaurant.setName(name)
                    .setAddress(address)
                    .setMenu(Arrays.asList(menu.split(":")));
            Restaurant savedCustomer = this.restaurantController.save(restaurant);
            displayRestaurant(restaurant);
        }catch (RestaurantExistsException e){
            e.getMessage();
            newRestaurantForm();
        }
    }
    public void displayRestaurant(Restaurant restaurant) {
        displayMenuHeader("Restaurant Details");
        System.out.printf("%-10s %-30s %-80s %-30s\n", "Id", "Name", "Address", "Menu Items");
        printDashLine();
        System.out.printf("%-10s %-30s %-80s %-30s\n", restaurant.getId(), restaurant.getName(), restaurant.getAddress(), String.join(":", restaurant.getMenu()));
    }

}
