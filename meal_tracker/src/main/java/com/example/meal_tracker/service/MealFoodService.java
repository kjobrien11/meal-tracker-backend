package com.example.meal_tracker.service;

import com.example.meal_tracker.dto.MealFoodDTO;
import com.example.meal_tracker.model.Meal;
import com.example.meal_tracker.model.MealFood;

import java.util.List;

public interface MealFoodService {
    public List<MealFoodDTO> findByMealId(Integer mealId);
    public MealFoodDTO createMealFood(MealFood mealFood);
    public MealFoodDTO findMealFoodById(Long id);
}
