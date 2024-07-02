package com.projects.foodiecliapp.util;

import com.projects.foodiecliapp.model.Customer;
import com.projects.foodiecliapp.model.Dish;
import com.projects.foodiecliapp.model.Restaurant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public List<Customer> readCustomersFromCsv(){

        List<Customer> customersList = new ArrayList<>();

        String customersCsvFilePath = "D:\\Java Full Stack\\Projects\\foodie-clie-app-java\\data\\customers.csv";

        try(BufferedReader br = new BufferedReader(new FileReader(customersCsvFilePath))){

            String line;
            String splitBy = ",";
            br.readLine();
            while ((line = br.readLine()) != null){
                String[] data = line.split(splitBy);
                Customer customer = new Customer();
                customer.setId(data[0])
                        .setName(data[1])
                        .setEmail(data[2])
                        .setPassword(data[3]);
                customersList.add(customer);
            }
        }catch(IOException e){

            System.out.println("Path not found in path : "+customersCsvFilePath);
            System.exit(0);
            e.printStackTrace();
        }
        return customersList;
    }

    public List<Dish> readDishesFromCsv(){

        List<Dish> dishesList = new ArrayList<>();

        String dishesCsvFilePath = "D:\\Java Full Stack\\Projects\\foodie-clie-app-java\\data\\dishes.csv";

        try(BufferedReader br = new BufferedReader(new FileReader(dishesCsvFilePath))){
            String splitBy = ",";
            String line;
            br.readLine();
            while ((line = br.readLine()) != null){
                String[] data = line.split(splitBy);
                Dish dish = new Dish();
                dish.setId(data[0]);
                dish.setName(data[1]);
                dish.setDescription(data[2]);
                dish.setPrice(data[3]);
            }
        }catch (IOException e){
            System.out.println("Path not found in path : " + dishesCsvFilePath);
            System.exit(0);
            e.printStackTrace();
        }
        return dishesList;
    }

    public List<Restaurant> readRestaurantsFromCsv(){

        List<Restaurant> restaurantList = new ArrayList<>();

        String restaurantCsvFilePath = "D:\\Java Full Stack\\Projects\\foodie-clie-app-java\\data\\restaurants.csv";

        try(BufferedReader br = new BufferedReader(new FileReader(restaurantCsvFilePath))){
            String splitBy = ",";
            String line;
            br.readLine();
            while ((line = br.readLine()) != null){
                String[] data = line.split(splitBy);
                Restaurant restaurant = new Restaurant();
                restaurant.setId(data[0])
                        .setName(data[1])
                        .setAddress(data[2])
                        .getMenu().add(data[3]);
            }
        }catch (IOException e){
            System.out.println("Path not found in path : " + restaurantCsvFilePath);
            System.exit(0);
            e.printStackTrace();
        }
        return restaurantList;
    }
}
