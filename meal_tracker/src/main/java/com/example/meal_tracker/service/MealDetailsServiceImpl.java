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
import jakarta.transaction.Transactional;
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
    @Transactional
    public FoodConsumedDTO addMealDetails(MealDetailsRequestDTO mealDetailsRequest) {
        Optional<Meal> meal = mealRepository.findById(mealDetailsRequest.mealId());
        Optional<Food> food = foodRepository.findById(mealDetailsRequest.foodId());

        //TODO add proper response when null
        if (meal.isEmpty() || food.isEmpty()) {
            return null;
        }

        MealDetails mealDetails = new MealDetails();
        mealDetails.setMeal(meal.get());
        mealDetails.setFood(food.get());
        mealDetails.setGrams(mealDetailsRequest.grams());

        MealDetails mealDetailsSaved = mealDetailsRepository.save(mealDetails);
        return MealSummaryCalculator.calculateFoodAddedSummary(mealDetailsSaved);
    }

    @Override
    @Transactional
    public List<FoodConsumedDTO> addMealDetailsFromList(List<MealDetailsRequestDTO> mealDetailsRequest) {
        List<FoodConsumedDTO> foodConsumedDTOList = new ArrayList<>();

        for (MealDetailsRequestDTO mealDetailsRequestDTO : mealDetailsRequest) {
            foodConsumedDTOList.add(addMealDetails(mealDetailsRequestDTO));
        }
        return foodConsumedDTOList;
    }
}