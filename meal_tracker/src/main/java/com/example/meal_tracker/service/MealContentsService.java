package com.example.meal_tracker.service;

import com.example.meal_tracker.dto.FoodConsumedDTO;
import com.example.meal_tracker.dto.MealContentsDTO;
import com.example.meal_tracker.dto.MealContentsRequestDTO;

import java.util.List;

public interface MealContentsService {
    public MealContentsDTO findByMealId(Integer mealId);
    public FoodConsumedDTO addMealContents(MealContentsRequestDTO mealContentsRequest);
    public List<FoodConsumedDTO> addMealContentsFromList(List<MealContentsRequestDTO> mealContentsRequest);
}
