package com.example.meal_tracker.dto;

import java.math.BigDecimal;

public record FoodConsumedDTO(
    FoodDTO food,
    BigDecimal calories,
    BigDecimal grams)
{}
