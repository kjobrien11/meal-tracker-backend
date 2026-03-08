package com.example.meal_tracker.dto;

import java.math.BigDecimal;

public record FoodDTO(
    String name,
    BigDecimal caloriesPerGram,
    BigDecimal proteinPerGram,
    BigDecimal carbsPerGram,
    BigDecimal fatPerGram)
{}
