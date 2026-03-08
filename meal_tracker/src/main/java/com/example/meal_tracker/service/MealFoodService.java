package com.example.meal_tracker.service;

import com.example.meal_tracker.model.Meal;
import com.example.meal_tracker.model.MealFood;

import java.util.List;

public interface MealFoodService {
    public List<MealFood> findByMealId(Integer mealId);
    public MealFood createMealFood(MealFood mealFood);
    public MealFood findMealFoodById(Long id);
}
