package com.example.meal_tracker.service;

import com.example.meal_tracker.model.Food;

import java.util.List;

public interface FoodService {

    public List<Food> getAllFoods();
    public Food getFoodById(Integer id);
    public Food createFood(Food food);
}
