package com.example.meal_tracker.service;

import com.example.meal_tracker.dto.FoodConsumedDTO;
import com.example.meal_tracker.dto.MealContentsDTO;
import com.example.meal_tracker.dto.MealContentsRequestDTO;
import com.example.meal_tracker.mapping.Mapper;
import com.example.meal_tracker.model.Food;
import com.example.meal_tracker.model.Meal;
import com.example.meal_tracker.model.MealContents;
import com.example.meal_tracker.repository.FoodRepository;
import com.example.meal_tracker.repository.MealContentsRepository;
import com.example.meal_tracker.repository.MealRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MealContentsServiceImpl implements MealContentsService {

    @Autowired
    private MealContentsRepository mealContentsRepository;

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public MealContentsDTO findByMealId(Integer mealId) {
        List<MealContents> mealContents = mealContentsRepository.findAllByMeal_Id(mealId);
        MealSummary summary = MealSummaryCalculator.calculateMealSummary(mealContents);
        return Mapper.mealContentsToDTO(mealContents.get(0), summary.getFoods(), summary.getTotalCalories(), summary.getTotalGrams());
    }

    @Override
    @Transactional
    public FoodConsumedDTO addMealContents(MealContentsRequestDTO mealContentsRequest) {
        Optional<Meal> meal = mealRepository.findById(mealContentsRequest.mealId());
        Optional<Food> food = foodRepository.findById(mealContentsRequest.foodId());

        //TODO add proper response when null
        if (meal.isEmpty() || food.isEmpty()) {
            return null;
        }

        MealContents mealContents = new MealContents();
        mealContents.setMeal(meal.get());
        mealContents.setFood(food.get());
        mealContents.setGrams(mealContentsRequest.grams());

        MealContents mealContentsSaved = mealContentsRepository.save(mealContents);
        return MealSummaryCalculator.calculateFoodAddedSummary(mealContentsSaved);
    }

    @Override
    @Transactional
    public List<FoodConsumedDTO> addMealContentsFromList(List<MealContentsRequestDTO> mealContentsRequest) {
        List<FoodConsumedDTO> foodConsumedDTOList = new ArrayList<>();

        for (MealContentsRequestDTO mealContentsRequestDTO : mealContentsRequest) {
            foodConsumedDTOList.add(addMealContents(mealContentsRequestDTO));
        }
        return foodConsumedDTOList;
    }
}