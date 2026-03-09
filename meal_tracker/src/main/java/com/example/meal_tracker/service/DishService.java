package com.example.meal_tracker.service;

import com.example.meal_tracker.dto.CreateDishRequestDTO;
import com.example.meal_tracker.dto.DishDTO;

import java.util.List;

public interface DishService {
    public DishDTO createDish(CreateDishRequestDTO dish);
    public List<DishDTO> getAllDishes();
}
