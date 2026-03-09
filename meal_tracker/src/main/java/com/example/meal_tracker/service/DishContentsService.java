package com.example.meal_tracker.service;

import com.example.meal_tracker.model.Dish;
import com.example.meal_tracker.model.DishContents;

import java.util.List;

public interface DishContentsService {
    public DishContents createDishContents(DishContents dish);
    public List<DishContents> getAllDishContents();
}
