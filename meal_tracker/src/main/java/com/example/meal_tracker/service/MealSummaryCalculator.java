package com.example.meal_tracker.service;

import com.example.meal_tracker.dto.FoodConsumedDTO;
import com.example.meal_tracker.mapping.Mapper;
import com.example.meal_tracker.model.MealFood;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MealSummaryCalculator {

    public static MealSummary calculateMealSummary(List<MealFood> mealFoods) {
        List<FoodConsumedDTO> foods = new ArrayList<>();
        BigDecimal totalCalories = BigDecimal.ZERO;
        BigDecimal totalGrams = BigDecimal.ZERO;

        for(MealFood mealFood : mealFoods) {
            BigDecimal grams = mealFood.getGrams();
            BigDecimal calories = grams.multiply(mealFood.getFood().getCaloriesPerGram());

            foods.add(new FoodConsumedDTO(Mapper.foodToDTO(mealFood.getFood()), calories, grams));

            totalCalories = totalCalories.add(calories);
            totalGrams = totalGrams.add(grams);
        }
        return new MealSummary(foods, totalCalories, totalGrams);
    }
}
