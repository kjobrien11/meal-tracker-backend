package com.example.meal_tracker.service;

import com.example.meal_tracker.dto.FoodDTO;
import com.example.meal_tracker.model.Food;

import java.util.List;

public interface FoodService {

    public List<FoodDTO> getAllFoods();
    public FoodDTO getFoodById(Integer id);
    public FoodDTO createFood(Food food);
}
