package com.projects.foodiecliapp.service;

import com.projects.foodiecliapp.exceptions.DishExistsException;
import com.projects.foodiecliapp.exceptions.DishNotFoundException;
import com.projects.foodiecliapp.model.Dish;
import com.projects.foodiecliapp.repository.DishRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class DishServiceImpl implements DishService{

    private DishRepositoryImpl dishRepository;
    public DishServiceImpl(DishRepositoryImpl dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Dish> getDishList() {
        return dishRepository.getDishList();
    }

    @Override
    public Dish save(Dish dish) throws DishExistsException {
        Optional<Dish> dishById = this.dishRepository.getDishById(dish.getId());
        if(dishById.isPresent())
            throw new DishExistsException("Dish already exists with Id: " + dish.getId());
        return this.dishRepository.save(dish);
    }

    @Override
    public Dish getDishById(String id) throws DishNotFoundException {
        Optional<Dish> dishById = this.dishRepository.getDishById(id);
        if(dishById.isEmpty())
            throw new DishNotFoundException("Dish not found with Id: " + id);
        return dishById.get();
    }

    @Override
    public Dish updateDish(Dish dish) throws DishNotFoundException {
        Optional<Dish> dishById = this.dishRepository.getDishById(dish.getId());
        if(dishById.isEmpty())
            throw new DishNotFoundException("Dish not found with Id: " + dish.getId());
        return this.dishRepository.updateDish(dish);
    }

    @Override
    public void deleteDish(String id) throws DishNotFoundException {
        Optional<Dish> dishById = this.dishRepository.getDishById(id);
        if(dishById.isEmpty())
            throw new DishNotFoundException("Dish not found with Id: " + id);
        this.dishRepository.deleteDish(dishById.get());
    }
}
