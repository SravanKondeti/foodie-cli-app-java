package com.projects.foodiecliapp.service;

import com.projects.foodiecliapp.exceptions.RestaurantExistsException;
import com.projects.foodiecliapp.exceptions.RestaurantNotFoundException;
import com.projects.foodiecliapp.model.Restaurant;
import com.projects.foodiecliapp.repository.RestaurantRepository;

import java.util.List;
import java.util.Optional;

public class RestaurantServiceImpl implements RestaurantService{

    private RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return this.restaurantRepository.getRestaurantList();
    }

    @Override
    public Restaurant getRestaurantById(String Id) throws RestaurantNotFoundException {
        Optional<Restaurant> restaurantById = this.restaurantRepository.getRestaurantById(Id);
        if(restaurantById.isEmpty())
            throw new RestaurantNotFoundException("Restaurant not found with Id : " + Id);
        return restaurantById.get();
    }

    @Override
    public Restaurant save(Restaurant restaurant) throws RestaurantExistsException {
        Optional<Restaurant> restaurantById = this.restaurantRepository.getRestaurantById(restaurant.getId());
        if(restaurantById.isPresent())
            throw new RestaurantExistsException("Restaurant already exists with Id : " + restaurant.getId());
        return this.restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurantToBeUpdated) throws RestaurantNotFoundException {
        Optional<Restaurant> restaurant = this.restaurantRepository.getRestaurantById(restaurantToBeUpdated.getId());
        if(restaurant.isEmpty())
            throw new RestaurantNotFoundException("Restaurant not found with Id : " + restaurantToBeUpdated.getId());
        return this.restaurantRepository.updateRestaurant(restaurantToBeUpdated);
    }

    @Override
    public void deleteRestaurant(String Id) throws RestaurantNotFoundException {
        Optional<Restaurant> restaurant = this.restaurantRepository.getRestaurantById(Id);
        if(restaurant.isEmpty())
            throw new RestaurantNotFoundException("Restaurant not found with Id : " + Id);
        this.restaurantRepository.deleteRestaurant(restaurant.get());
    }
}
