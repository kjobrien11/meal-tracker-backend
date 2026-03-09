package com.example.meal_tracker.service;

import com.example.meal_tracker.dto.FoodConsumedDTO;
import com.example.meal_tracker.mapping.Mapper;
import com.example.meal_tracker.model.MealDetails;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MealSummaryCalculator {

    public static MealSummary calculateMealSummary(List<MealDetails> mealDetails) {
        List<FoodConsumedDTO> foods = new ArrayList<>();
        BigDecimal totalCalories = BigDecimal.ZERO;
        BigDecimal totalGrams = BigDecimal.ZERO;

        for(MealDetails foodItem : mealDetails) {
            BigDecimal grams = foodItem.getGrams();
            BigDecimal calories = grams.multiply(foodItem.getFood().getCaloriesPerGram());

            foods.add(new FoodConsumedDTO(Mapper.foodToDTO(foodItem.getFood()), calories, grams));

            totalCalories = totalCalories.add(calories);
            totalGrams = totalGrams.add(grams);
        }
        return new MealSummary(foods, totalCalories, totalGrams);
    }

    public static FoodConsumedDTO calculateFoodAddedSummary(MealDetails mealDetails) {

        BigDecimal grams = mealDetails.getGrams();
        BigDecimal calories = grams.multiply(mealDetails.getFood().getCaloriesPerGram());


        return new FoodConsumedDTO(Mapper.foodToDTO(mealDetails.getFood()), calories, grams);
    }
}
