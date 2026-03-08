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
        List<FoodConsumedDTO> foods = deriveFoodConsumedDTO(mealFoods);
        BigDecimal totalCalories = calculateTotalCalories(foods);
        BigDecimal totalGrams = calculateTotalGrams(foods);
        return Mapper.mealFoodToDTO(mealFoods.get(0), foods, totalCalories, totalGrams);
    }

    @Override
    public MealFoodDTO createMealFood(MealFood mealFood) {
        MealFood mealFoodSaved = mealFoodRepository.save(mealFood);
        return Mapper.mealFoodToDTO(mealFoodSaved, List.of(), BigDecimal.ZERO, BigDecimal.ZERO);
    }

    private List<FoodConsumedDTO> deriveFoodConsumedDTO(List<MealFood> mealFoods) {
        List<FoodConsumedDTO> foods = new ArrayList<>();
        for (MealFood mealFood : mealFoods) {
            BigDecimal calories = mealFood.getGrams().multiply(mealFood.getFood().getCaloriesPerGram());
            foods.add(new FoodConsumedDTO(Mapper.foodToDTO(mealFood.getFood()), calories, mealFood.getGrams()));
        }
        return foods;
    }

    private BigDecimal calculateTotalCalories(List<FoodConsumedDTO> foodConsumed) {
        BigDecimal totalCalories = BigDecimal.ZERO;
        for (FoodConsumedDTO foodConsumedDTO : foodConsumed) {
            totalCalories = totalCalories.add(foodConsumedDTO.calories());
        }
        return totalCalories;
    }

    private BigDecimal calculateTotalGrams(List<FoodConsumedDTO> foodConsumed) {
        BigDecimal totalGrams = BigDecimal.ZERO;
        for (FoodConsumedDTO foodConsumedDTO : foodConsumed) {
            totalGrams = totalGrams.add(foodConsumedDTO.grams());
        }
        return totalGrams;
    }


}
