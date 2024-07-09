package com.projects.foodiecliapp.service;

import com.projects.foodiecliapp.exceptions.DishExistsException;
import com.projects.foodiecliapp.exceptions.DishNotFoundException;
import com.projects.foodiecliapp.model.Dish;

import java.util.List;

public interface DishService {

    public List<Dish> getDishList();
    public Dish save(Dish dish) throws DishExistsException;
    public Dish getDishById(String id) throws DishNotFoundException;
    public Dish updateDish(Dish dish) throws DishNotFoundException;
    public void deleteDish(String id) throws DishNotFoundException;

}
