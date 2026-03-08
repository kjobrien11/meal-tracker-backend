package com.example.meal_tracker.service;

import com.example.meal_tracker.dto.MealFoodDTO;
import com.example.meal_tracker.dto.MealFoodRequestDTO;
import com.example.meal_tracker.model.MealFood;

public interface MealFoodService {
    public MealFoodDTO findByMealId(Integer mealId);
    public MealFoodDTO createMealFood(MealFoodRequestDTO mealFoodRequest);
}
