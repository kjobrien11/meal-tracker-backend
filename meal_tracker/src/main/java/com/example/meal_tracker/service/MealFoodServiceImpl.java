package com.example.meal_tracker.service;

import com.example.meal_tracker.dto.FoodConsumedDTO;
import com.example.meal_tracker.dto.MealFoodDTO;
import com.example.meal_tracker.dto.MealFoodRequestDTO;
import com.example.meal_tracker.mapping.Mapper;
import com.example.meal_tracker.model.Food;
import com.example.meal_tracker.model.Meal;
import com.example.meal_tracker.model.MealFood;
import com.example.meal_tracker.repository.FoodRepository;
import com.example.meal_tracker.repository.MealFoodRepository;
import com.example.meal_tracker.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealFoodServiceImpl implements MealFoodService {

    @Autowired
    private MealFoodRepository mealFoodRepository;

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public MealFoodDTO findByMealId(Integer mealId) {
        List<MealFood> mealFoods = mealFoodRepository.findAllByMeal_Id(mealId);
        MealSummary summary = MealSummaryCalculator.calculateMealSummary(mealFoods);
        return Mapper.mealFoodToDTO(mealFoods.get(0), summary.getFoods(), summary.getTotalCalories(), summary.getTotalGrams());
    }

    @Override
    public MealFoodDTO createMealFood(MealFoodRequestDTO mealFoodRequest) {
        Optional<Meal> meal = mealRepository.findById(mealFoodRequest.mealId());
        Optional<Food> food = foodRepository.findById(mealFoodRequest.foodId());

        if (meal.isEmpty() || food.isEmpty()) {
            return null;
        }

        MealFood mealFood = new MealFood();
        mealFood.setMeal(meal.get());
        mealFood.setFood(food.get());
        mealFood.setGrams(mealFoodRequest.grams());

        MealFood mealFoodSaved = mealFoodRepository.save(mealFood);
        MealSummary summary = MealSummaryCalculator.calculateMealSummary(List.of(mealFoodSaved));
        return Mapper.mealFoodToDTO(mealFoodSaved, summary.getFoods(), summary.getTotalCalories(), summary.getTotalGrams());
    }
}