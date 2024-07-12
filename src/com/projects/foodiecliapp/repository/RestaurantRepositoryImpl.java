package com.projects.foodiecliapp.repository;

import com.projects.foodiecliapp.model.Restaurant;
import com.projects.foodiecliapp.util.CsvReader;

import java.util.List;
import java.util.Optional;

public class RestaurantRepositoryImpl implements RestaurantRepository{

    private List<Restaurant> restaurantList;

    public RestaurantRepositoryImpl() {
        CsvReader csvReader = new CsvReader();
        this.restaurantList = csvReader.readRestaurantsFromCsv();
    }

    @Override
    public List<Restaurant> getRestaurantList() {
        return restaurantList;
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        this.restaurantList.add(restaurant);
        return restaurant;
    }

    @Override
    public Optional<Restaurant> getRestaurantById(String Id) {
        return this.restaurantList.stream().filter(restaurant -> restaurant.getId().equals(Id)).findFirst();
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurantToBeUpdated) {
        Optional<Restaurant> updateRestaurant = this.restaurantList.stream().filter(restaurant -> restaurant.getId().equals(restaurantToBeUpdated.getId()))
                .findFirst()
                .map(restaurant -> {
                    restaurant.setMenu(restaurantToBeUpdated.getMenu())
                                .setName(restaurantToBeUpdated.getName())
                                .setAddress(restaurantToBeUpdated.getAddress());
                return restaurant;
    });
        return updateRestaurant.orElse(null);
    }

    @Override
    public void deleteRestaurant(Restaurant restaurant) {
        this.restaurantList.remove(restaurant);
    }
}
