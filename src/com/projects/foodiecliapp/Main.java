package com.projects.foodiecliapp;

import com.projects.foodiecliapp.repository.CustomerRepositoryImpl;
import com.projects.foodiecliapp.ui.Menu;
import com.projects.foodiecliapp.util.CsvReader;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.displayMenu();
    }
}
