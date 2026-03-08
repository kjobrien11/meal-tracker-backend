package com.example.meal_tracker.service;

import com.example.meal_tracker.model.Meal;

import java.time.LocalDate;
import java.util.List;

public interface MealService {
    public List<Meal> getMeals();
    public List<Meal> getMealsForDate(LocalDate date);
    public Meal createMeal(Meal meal);
    public Meal getMealById(Integer id);
}
