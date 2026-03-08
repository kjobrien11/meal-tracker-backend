package com.example.meal_tracker.controller;

import com.example.meal_tracker.model.Food;
import com.example.meal_tracker.repository.FoodRepository;
import com.example.meal_tracker.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/foods")
    public List<Food> getFoods() {
        return foodService.getAllFoods();
    }

    @PostMapping("/foods")
    public Food createFood(@RequestBody Food food) {
        return foodService.createFood(food);
    }
}
