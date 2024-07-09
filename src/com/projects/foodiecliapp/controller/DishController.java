package com.projects.foodiecliapp.controller;

import com.projects.foodiecliapp.exceptions.DishExistsException;
import com.projects.foodiecliapp.exceptions.DishNotFoundException;
import com.projects.foodiecliapp.model.Dish;
import com.projects.foodiecliapp.service.DishServiceImpl;

import java.util.List;

public class DishController {

    private DishServiceImpl dishService;

    public DishController(DishServiceImpl dishService) {
        this.dishService = dishService;
    }

    public List<Dish> dishList(){
        return this.dishService.getDishList();
    }

    public Dish save(Dish dish) throws DishExistsException {
        return this.dishService.save(dish);
    }

    public Dish getDishById(String id) throws DishNotFoundException {
        return this.dishService.getDishById(id);
    }

    public void deleteDish(String id) throws DishNotFoundException{
        this.dishService.deleteDish(id);
    }

    public Dish updateDish(Dish dish) throws DishNotFoundException {
        return this.dishService.updateDish(dish);
    }

}
