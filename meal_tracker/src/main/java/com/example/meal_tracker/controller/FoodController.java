package com.example.meal_tracker.controller;

import com.example.meal_tracker.model.Food;
import com.example.meal_tracker.repository.FoodRepository;
import com.example.meal_tracker.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")

public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping
    public List<Food> getFoods() {
        return foodService.getAllFoods();
    }

    @PostMapping
    public Food createFood(@RequestBody Food food) {
        return foodService.createFood(food);
    }
}
