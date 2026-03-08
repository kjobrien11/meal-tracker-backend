package com.example.meal_tracker.service;

import com.example.meal_tracker.dto.MealDetailsDTO;
import com.example.meal_tracker.dto.MealDetailsRequestDTO;

public interface MealDetailsService {
    public MealDetailsDTO findByMealId(Integer mealId);
    public MealDetailsDTO createMealFood(MealDetailsRequestDTO mealFoodRequest);
}
