package com.example.meal_tracker.service;

import com.example.meal_tracker.dto.FoodConsumedDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class MealSummary {
    private final List<FoodConsumedDTO> foods;
    private final BigDecimal totalCalories;
    private final BigDecimal totalGrams;
}
