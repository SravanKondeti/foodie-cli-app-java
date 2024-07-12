package com.projects.foodiecliapp.repository;

import com.projects.foodiecliapp.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository {

    public List<Restaurant> getRestaurantList();
    public Restaurant save(Restaurant restaurant);
    public Optional<Restaurant> getRestaurantById(String Id);
    public Restaurant updateRestaurant(Restaurant restaurant);
    public void deleteRestaurant(Restaurant restaurant);
}
