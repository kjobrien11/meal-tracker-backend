package com.example.meal_tracker.service;

import com.example.meal_tracker.dto.DishDTO;
import com.example.meal_tracker.model.Dish;

import java.util.List;

public interface DishService {
    public Dish createDish(Dish dish);
    public List<DishDTO> getAllDishes();
}
