package com.example.meal_tracker.mapping;

import com.example.meal_tracker.dto.FoodDTO;
import com.example.meal_tracker.dto.MealDTO;
import com.example.meal_tracker.dto.MealFoodDTO;
import com.example.meal_tracker.model.Food;
import com.example.meal_tracker.model.Meal;
import com.example.meal_tracker.model.MealFood;

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

    public static MealFoodDTO mealFoodToDTO(MealFood mealFood) {
        return new MealFoodDTO(
                mealFood.getMeal().getMealName(),
                mealFood.getMeal().getDate(),
                -1,
                -1,
                List.of());
    }
}
