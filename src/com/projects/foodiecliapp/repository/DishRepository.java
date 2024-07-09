package com.projects.foodiecliapp.repository;

import com.projects.foodiecliapp.model.Dish;

import java.util.List;
import java.util.Optional;

public interface DishRepository {

    public List<Dish> getDishList();
    public Dish save(Dish dish);
    public Optional<Dish> getDishById(String id);
    public void deleteDish(Dish dishToBeDeleted);
    public Dish updateDish(Dish dishToBeUpdated);
}
