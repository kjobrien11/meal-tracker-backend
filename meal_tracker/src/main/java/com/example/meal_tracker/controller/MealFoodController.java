package com.example.meal_tracker.controller;

import com.example.meal_tracker.dto.MealFoodDTO;
import com.example.meal_tracker.dto.MealFoodRequestDTO;
import com.example.meal_tracker.model.MealFood;
import com.example.meal_tracker.service.MealFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meal-details")
public class MealFoodController {

    @Autowired
    private MealFoodService mealFoodService;

    @GetMapping("/{id}")
    public MealFoodDTO findByMealId(@PathVariable Integer id) {
        return mealFoodService.findByMealId(id);
    }

    @PostMapping
    public MealFoodDTO createMealFood(@RequestBody MealFoodRequestDTO mealFoodRequest) {
        return mealFoodService.createMealFood(mealFoodRequest);
    }

}
