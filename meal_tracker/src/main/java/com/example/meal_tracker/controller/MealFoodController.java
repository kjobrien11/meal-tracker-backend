package com.example.meal_tracker.controller;

import com.example.meal_tracker.model.MealFood;
import com.example.meal_tracker.service.MealFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meals-with-food")
public class MealFoodController {

    @Autowired
    private MealFoodService mealFoodService;

    @GetMapping("/{id}")
    public List<MealFood> findByMealId(@PathVariable Integer id) {
        return mealFoodService.findByMealId(id);
    }

    @PostMapping
    public MealFood createMealFood(@RequestBody MealFood mealFood) {
        return mealFoodService.createMealFood(mealFood);
    }

}
