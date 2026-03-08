package com.example.meal_tracker.service;

import com.example.meal_tracker.model.Meal;
import com.example.meal_tracker.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealServiceImpl implements MealService {

    @Autowired
    private MealRepository mealRepository;

    @Override
    public Meal createMeal(Meal meal) {
        return mealRepository.save(meal);
    }

    @Override
    public Meal getMealById(Integer id) {
        return mealRepository.findById(id).get();
    }
}
