package com.example.meal_tracker.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record MealDetailsDTO(
    String mealName,
    LocalDate date,
    BigDecimal totalCalories,
    BigDecimal totalGrams,
    List<FoodConsumedDTO> foods)
{}
