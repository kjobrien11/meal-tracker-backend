package com.example.meal_tracker.dto;

import com.example.meal_tracker.model.FoodConsumedDTO;

import java.time.LocalDate;
import java.util.List;

public record MealFoodDTO(
    String mealName,
    LocalDate date,
    double totalCalories,
    double totalGrams,
    List<FoodConsumedDTO> foods)
{}
