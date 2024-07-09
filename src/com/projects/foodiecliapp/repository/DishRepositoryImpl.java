package com.projects.foodiecliapp.repository;

import com.projects.foodiecliapp.exceptions.DishExistsException;
import com.projects.foodiecliapp.factory.Factory;
import com.projects.foodiecliapp.model.Dish;

import java.util.List;
import java.util.Optional;

public class DishRepositoryImpl implements DishRepository{

    List<Dish> dishList;

    public DishRepositoryImpl() {
        this.dishList = Factory.getCsvReader().readDishesFromCsv();
    }

    @Override
    public List<Dish> getDishList() {
        return this.dishList;
    }

    @Override
    public Dish save(Dish dish){
        this.dishList.add(dish);
        return dish;
    }

    @Override
    public Optional<Dish> getDishById(String id) {
        return this.dishList.stream().filter(dish -> dish.getId().equals(id)).findFirst();
    }

    @Override
    public void deleteDish(Dish dishToBeDeleted) {
        this.dishList.remove(dishToBeDeleted);
    }

    @Override
    public Dish updateDish(Dish dishToBeUpdated) {
        Optional<Dish> updateDish = this.dishList.stream().filter(dish -> dish.getId().equals(dishToBeUpdated.getId()))
                .findFirst()
                .map(dish -> {
                    dish.setName(dishToBeUpdated.getName())
                            .setPrice(dishToBeUpdated.getPrice())
                            .setDescription(dishToBeUpdated.getDescription());
                    return dish;
                });
        return updateDish.orElse(null);
    }
}
