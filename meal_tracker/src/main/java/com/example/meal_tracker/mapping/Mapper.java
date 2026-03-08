package com.example.meal_tracker.mapping;

import com.example.meal_tracker.dto.MealDTO;
import com.example.meal_tracker.model.Meal;

public class Mapper {

    public static MealDTO mealToDTO(Meal meal) {
        return new MealDTO(meal.getMealName(), meal.getDate());
    }
}
