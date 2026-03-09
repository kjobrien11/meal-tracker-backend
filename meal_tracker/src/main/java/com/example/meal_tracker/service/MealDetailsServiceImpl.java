package com.example.meal_tracker.service;

import com.example.meal_tracker.dto.FoodConsumedDTO;
import com.example.meal_tracker.dto.MealDetailsDTO;
import com.example.meal_tracker.dto.MealDetailsRequestDTO;
import com.example.meal_tracker.mapping.Mapper;
import com.example.meal_tracker.model.Food;
import com.example.meal_tracker.model.Meal;
import com.example.meal_tracker.model.MealDetails;
import com.example.meal_tracker.repository.FoodRepository;
import com.example.meal_tracker.repository.MealDetailsRepository;
import com.example.meal_tracker.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MealDetailsServiceImpl implements MealDetailsService {

    @Autowired
    private MealDetailsRepository mealDetailsRepository;

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public MealDetailsDTO findByMealId(Integer mealId) {
        List<MealDetails> mealDetails = mealDetailsRepository.findAllByMeal_Id(mealId);
        MealSummary summary = MealSummaryCalculator.calculateMealSummary(mealDetails);
        return Mapper.mealDetailsToDTO(mealDetails.get(0), summary.getFoods(), summary.getTotalCalories(), summary.getTotalGrams());
    }

    @Override
    public FoodConsumedDTO createMealFood(MealDetailsRequestDTO mealFoodRequest) {
        Optional<Meal> meal = mealRepository.findById(mealFoodRequest.mealId());
        Optional<Food> food = foodRepository.findById(mealFoodRequest.foodId());

        //TODO add proper response when null
        if (meal.isEmpty() || food.isEmpty()) {
            return null;
        }

        MealDetails mealDetails = new MealDetails();
        mealDetails.setMeal(meal.get());
        mealDetails.setFood(food.get());
        mealDetails.setGrams(mealFoodRequest.grams());

        MealDetails mealDetailsSaved = mealDetailsRepository.save(mealDetails);
        return MealSummaryCalculator.calculateFoodAddedSummary(mealDetailsSaved);
    }

    @Override
    public List<FoodConsumedDTO> createMealFoodFromList(List<MealDetailsRequestDTO> mealFoodRequest) {
        List<FoodConsumedDTO> foodConsumedDTOList = new ArrayList<>();

        for (MealDetailsRequestDTO mealFoodRequestDTO : mealFoodRequest) {
            foodConsumedDTOList.add(createMealFood(mealFoodRequestDTO));
        }
        return foodConsumedDTOList;
    }
}