package com.example.meal_tracker.service;

import com.example.meal_tracker.model.MealFood;
import com.example.meal_tracker.repository.MealFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealFoodServiceImpl implements MealFoodService {

    @Autowired
    private MealFoodRepository mealFoodRepository;

    @Override
    public List<MealFood> findByMealId(Integer mealId) {
        return mealFoodRepository.findAllByMeal_Id(mealId);
    }

    @Override
    public MealFood createMealFood(MealFood mealFood) {
        return mealFoodRepository.save(mealFood);
    }

    @Override
    public MealFood findMealFoodById(Long id) {
        return mealFoodRepository.findById(id).get();
    }
}
