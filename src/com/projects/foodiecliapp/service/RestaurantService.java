package com.projects.foodiecliapp.service;

import com.projects.foodiecliapp.exceptions.RestaurantExistsException;
import com.projects.foodiecliapp.exceptions.RestaurantNotFoundException;
import com.projects.foodiecliapp.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    public List<Restaurant> getAllRestaurants();
    public Restaurant getRestaurantById(String Id) throws RestaurantNotFoundException;
    public Restaurant save(Restaurant restaurant) throws RestaurantExistsException;
    public Restaurant updateRestaurant(Restaurant restaurantToBeUpdated) throws RestaurantNotFoundException;
    public void deleteRestaurant(String Id) throws RestaurantNotFoundException;
}
