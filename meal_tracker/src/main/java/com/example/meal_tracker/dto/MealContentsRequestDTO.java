package com.example.meal_tracker.dto;

import java.math.BigDecimal;

public record MealContentsRequestDTO(
    Integer mealId,
    Integer foodId,
    BigDecimal grams)
{}
