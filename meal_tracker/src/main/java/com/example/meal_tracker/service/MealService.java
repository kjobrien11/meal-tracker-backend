package com.example.meal_tracker.service;

import com.example.meal_tracker.model.Meal;

public interface MealService {
    public Meal createMeal(Meal meal);
    public Meal getMealById(Integer id);
}
