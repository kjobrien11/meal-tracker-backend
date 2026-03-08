package com.example.meal_tracker.dto;

import java.math.BigDecimal;

public record MealFoodRequestDTO(
    Integer mealId,
    Integer foodId,
    BigDecimal grams)
{}
