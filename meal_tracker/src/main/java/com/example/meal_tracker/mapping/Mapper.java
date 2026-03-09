package com.example.meal_tracker.mapping;

import com.example.meal_tracker.dto.FoodConsumedDTO;
import com.example.meal_tracker.dto.FoodDTO;
import com.example.meal_tracker.dto.MealDTO;
import com.example.meal_tracker.dto.MealContentsDTO;
import com.example.meal_tracker.model.Food;
import com.example.meal_tracker.model.Meal;
import com.example.meal_tracker.model.MealContents;

import java.math.BigDecimal;
import java.util.List;

public class Mapper {

    public static MealDTO mealToDTO(Meal meal) {
        return new MealDTO(
                meal.getMealName(),
                meal.getDate());
    }

    public static FoodDTO foodToDTO(Food food) {
        return new FoodDTO(
                food.getName(),
                food.getCaloriesPerGram(),
                food.getProteinPerGram(),
                food.getCarbsPerGram(),
                food.getFatPerGram());
    }

    public static MealContentsDTO mealContentsToDTO(MealContents mealContents, List<FoodConsumedDTO> foods, BigDecimal totalCalories, BigDecimal totalGrams) {
        return new MealContentsDTO(
                mealContents.getMeal().getMealName(),
                mealContents.getMeal().getDate(),
                totalCalories,
                totalGrams,
                foods);
    }
}
