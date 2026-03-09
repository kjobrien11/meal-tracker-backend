package com.example.meal_tracker.dto;

import java.util.List;

public record DishDTO(
    String dishName,
    List<FoodDTO> contents)
{}
