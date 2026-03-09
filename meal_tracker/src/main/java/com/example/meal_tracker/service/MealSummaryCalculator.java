package com.example.meal_tracker.service;

import com.example.meal_tracker.dto.FoodConsumedDTO;
import com.example.meal_tracker.mapping.Mapper;
import com.example.meal_tracker.model.MealContents;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MealSummaryCalculator {

    public static MealSummary calculateMealSummary(List<MealContents> mealContents) {
        List<FoodConsumedDTO> foods = new ArrayList<>();
        BigDecimal totalCalories = BigDecimal.ZERO;
        BigDecimal totalGrams = BigDecimal.ZERO;

        for(MealContents foodItem : mealContents) {
            BigDecimal grams = foodItem.getGrams();
            BigDecimal calories = grams.multiply(foodItem.getFood().getCaloriesPerGram());

            foods.add(new FoodConsumedDTO(Mapper.foodToDTO(foodItem.getFood()), calories, grams));

            totalCalories = totalCalories.add(calories);
            totalGrams = totalGrams.add(grams);
        }
        return new MealSummary(foods, totalCalories, totalGrams);
    }

    public static FoodConsumedDTO calculateFoodAddedSummary(MealContents mealContents) {
        BigDecimal grams = mealContents.getGrams();
        BigDecimal calories = grams.multiply(mealContents.getFood().getCaloriesPerGram());
        return new FoodConsumedDTO(Mapper.foodToDTO(mealContents.getFood()), calories, grams);
    }
}
