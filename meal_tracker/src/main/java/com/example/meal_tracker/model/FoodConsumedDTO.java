package com.example.meal_tracker.model;

import com.example.meal_tracker.dto.FoodDTO;

public record FoodConsumedDTO(
    FoodDTO food,
    double calories,
    double grams)
{}
