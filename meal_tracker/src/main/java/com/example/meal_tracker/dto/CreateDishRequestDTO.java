package com.example.meal_tracker.dto;

import java.util.List;

public record CreateDishRequestDTO(
    String name,
    List<Integer> foodIds)
{}
