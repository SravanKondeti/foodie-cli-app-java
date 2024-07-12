package com.projects.foodiecliapp.controller;

import com.projects.foodiecliapp.exceptions.RestaurantExistsException;
import com.projects.foodiecliapp.exceptions.RestaurantNotFoundException;
import com.projects.foodiecliapp.model.Restaurant;
import com.projects.foodiecliapp.service.RestaurantService;
import com.projects.foodiecliapp.service.RestaurantServiceImpl;

import java.util.List;

public class RestaurantController {

    private RestaurantServiceImpl restaurantService;

    public RestaurantController(RestaurantServiceImpl restaurantService) {
        this.restaurantService = restaurantService;
    }

    public List<Restaurant> getRestaurantList(){
        return restaurantService.getAllRestaurants();
    }

    public Restaurant save(Restaurant restaurant) throws RestaurantExistsException {
        return this.restaurantService.save(restaurant);
    }
    public Restaurant getRestaurantById(String Id) throws RestaurantNotFoundException {
        return this.restaurantService.getRestaurantById(Id);
    }

    public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException {
        return this.restaurantService.updateRestaurant(restaurant);
    }

    public void deleteRestaurant(String Id) throws RestaurantNotFoundException {
        this.restaurantService.deleteRestaurant(Id);
    }
}
