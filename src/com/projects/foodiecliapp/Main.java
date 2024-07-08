package com.projects.foodiecliapp;

import com.projects.foodiecliapp.controller.DishController;
import com.projects.foodiecliapp.factory.Factory;
import com.projects.foodiecliapp.repository.CustomerRepositoryImpl;
import com.projects.foodiecliapp.service.DishServiceImpl;
import com.projects.foodiecliapp.ui.Menu;
import com.projects.foodiecliapp.util.CsvReader;

public class Main {

    public static void main(String[] args) {


//        DishController dishController  = Factory.getDishController();
//        System.out.println(dishController.dishList());

        Menu menu = new Menu();
        menu.displayMenu();
    }
}
