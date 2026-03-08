package com.example.meal_tracker.dto;

import java.time.LocalDate;

public record MealDTO(
    String mealName,
    LocalDate date)
{}
