package com.example.meal_tracker.service;

import com.example.meal_tracker.model.Dish;
import com.example.meal_tracker.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishRepository dishRepository;

    @Override
    public Dish createDish(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }
}
