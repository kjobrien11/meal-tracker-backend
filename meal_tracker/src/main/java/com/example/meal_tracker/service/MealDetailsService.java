package com.example.meal_tracker.service;

import com.example.meal_tracker.dto.FoodConsumedDTO;
import com.example.meal_tracker.dto.MealDetailsDTO;
import com.example.meal_tracker.dto.MealDetailsRequestDTO;

import java.util.List;

public interface MealDetailsService {
    public MealDetailsDTO findByMealId(Integer mealId);
    public FoodConsumedDTO createMealFood(MealDetailsRequestDTO mealFoodRequest);
    public List<FoodConsumedDTO> createMealFoodFromList(List<MealDetailsRequestDTO> mealFoodRequest);
}
