package com.example.meal_tracker.service;

import com.example.meal_tracker.dto.FoodConsumedDTO;
import com.example.meal_tracker.dto.MealFoodDTO;
import com.example.meal_tracker.mapping.Mapper;
import com.example.meal_tracker.model.MealFood;
import com.example.meal_tracker.repository.MealFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class MealFoodServiceImpl implements MealFoodService {

    @Autowired
    private MealFoodRepository mealFoodRepository;


    @Override
    public MealFoodDTO findByMealId(Integer mealId) {
        List<MealFood> mealFoods = mealFoodRepository.findAllByMeal_Id(mealId);
        MealSummary summary = MealSummaryCalculator.calculateMealSummary(mealFoods);
        return Mapper.mealFoodToDTO(mealFoods.get(0), summary.getFoods(), summary.getTotalCalories(), summary.getTotalGrams());
    }

    @Override
    public MealFoodDTO createMealFood(MealFood mealFood) {
        MealFood mealFoodSaved = mealFoodRepository.save(mealFood);
        MealSummary summary = MealSummaryCalculator.calculateMealSummary(List.of(mealFoodSaved));
        return Mapper.mealFoodToDTO(mealFoodSaved, summary.getFoods(), summary.getTotalCalories(), summary.getTotalGrams());
    }

}
