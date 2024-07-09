package com.projects.foodiecliapp.ui;

import com.projects.foodiecliapp.controller.DishController;
import com.projects.foodiecliapp.exceptions.DishExistsException;
import com.projects.foodiecliapp.exceptions.DishNotFoundException;
import com.projects.foodiecliapp.factory.Factory;
import com.projects.foodiecliapp.model.Dish;

import java.util.List;
import java.util.Scanner;

public class DishMenu extends Menu{

    private DishController dishController;

    public DishMenu() {
        this.dishController = Factory.getDishController();
    }
    String dashLine = new String(new char[150]).replace('\0', '-');

    @Override
    public void displayMenu() {
        try{
            Scanner scanner = new Scanner(System.in);

            while (true) {
                displayMenuHeader("WELCOME TO DISHES SECTION");
                System.out.println();
                System.out.println("Please select the option !");
                System.out.println("--------------------------");
                System.out.println("1. Add New Dish");
                System.out.println("2. View All Dish Items");
                System.out.println("3. Search Dish");
                System.out.println("4. Update Dish ");
                System.out.println("5. Delete Dish");
                System.out.println("6. Exit");

                System.out.println("Please enter your choice (1-6)");

                int input = scanner.nextInt();
                switch (input){
                    case 1 -> newDishForm();
                    case 2 -> displayDishes();
                    case 3 -> searchDishForm();
                    case 4 -> updateDishForm();
                    case 5 -> deleteDishForm();
                    case 6 -> {
                        System.out.println("Thanks You, See you again !");
                        super.displayMenu();
                    }
                    default -> System.out.println("Invalid Input. Please enter the valid input from(1-7)");
                }
            }
        }catch (Exception e){
            System.out.println("Some internal error occurred. Please try again !");
            displayMenu();
        }
    }

    private void deleteDishForm() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details to delete the Dish\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            dishController.deleteDish(id);
            System.out.println("Dish deleted successfully!");
        }catch (DishNotFoundException e){
            System.out.println(e.getMessage());
            displayMenu();
        }
    }

    private void updateDishForm() {
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details to update the Dish\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            System.out.println("Enter Name");
            String name = scanner.nextLine();
            System.out.println("Enter Description");
            String description = scanner.nextLine();
            System.out.println("Enter Price");
            double price = scanner.nextDouble();
            Dish dish = new Dish();
            dish.setName(name)
                    .setPrice(price)
                    .setDescription(description);
            this.dishController.updateDish(dish);
            System.out.println("Dish updated successfully.");
            displayDish(dish);
        }catch (DishNotFoundException e){
            System.out.println(e.getMessage());
            displayMenu();
        }
    }

    private void searchDishForm() {
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details to search for Customer\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            Dish dish = dishController.getDishById(id);
            displayDish(dish);
        }catch (DishNotFoundException e){
            System.out.println(e.getMessage());
            displayMenu();
        }
    }

    private void displayDishes() {
        List<Dish> dishesList = this.dishController.dishList();
        displayMenuHeader("Dish Items");
        System.out.printf("%-10s %-30s %-80s %-10s\n", "Id", "Name", "Description", "Price");
        System.out.println(dashLine);
        dishesList.forEach(dish -> {
            System.out.printf("%-10s %-30s %-80s %-10s\n", dish.getId(), dish.getName(), dish.getDescription(), String.format("$%.2f", dish.getPrice()));
        });
//        dishesList.forEach(this::displayDish);
    }

    private void newDishForm(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            System.out.println("Enter Name");
            String name = scanner.nextLine();
            System.out.println("Enter Description");
            String description = scanner.nextLine();
            System.out.println("Enter Price");
            double price = scanner.nextDouble();
            Dish dish = new Dish();
            dish.setId(id)
                    .setName(name)
                    .setDescription(description)
                    .setPrice(price);
            Dish saveDish = this.dishController.save(dish);
            displayDish(saveDish);
        }catch (DishExistsException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println("Some internal error occurred. Please try again");
            newDishForm();
        }

    }
    public void displayDish(Dish dish) {
        displayMenuHeader("Dish Details");
        System.out.printf("%-10s %-30s %-80s %-10s\n", "Id", "Name", "Description", "Price");
        printDashLine();
        System.out.printf("%-10s %-30s %-80s %-10s\n", dish.getId(), dish.getName(), dish.getDescription(), String.format("$%.2f", dish.getPrice()));
    }

}
