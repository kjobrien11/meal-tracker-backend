package com.example.meal_tracker.controller;

import com.example.meal_tracker.dto.FoodDTO;
import com.example.meal_tracker.model.Food;
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
    public List<FoodDTO> getFoods() {
        return foodService.getAllFoods();
    }

    @PostMapping
    public FoodDTO createFood(@RequestBody Food food) {
        return foodService.createFood(food);
    }
}
