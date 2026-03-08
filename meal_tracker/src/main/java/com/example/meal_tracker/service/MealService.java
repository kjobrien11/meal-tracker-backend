package com.example.meal_tracker.service;

import com.example.meal_tracker.dto.MealDTO;
import com.example.meal_tracker.model.Meal;

import java.time.LocalDate;
import java.util.List;

public interface MealService {
    public List<MealDTO> getMeals();
    public List<MealDTO> getMealsForDate(LocalDate date);
    public MealDTO createMeal(Meal meal);
    public MealDTO getMealById(Integer id);
}
