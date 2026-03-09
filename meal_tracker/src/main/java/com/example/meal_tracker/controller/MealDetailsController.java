package com.example.meal_tracker.controller;

import com.example.meal_tracker.dto.FoodConsumedDTO;
import com.example.meal_tracker.dto.MealDetailsDTO;
import com.example.meal_tracker.dto.MealDetailsRequestDTO;
import com.example.meal_tracker.service.MealDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meal-details")
public class MealDetailsController {

    @Autowired
    private MealDetailsService mealDetailsService;

    @GetMapping("/{id}")
    public MealDetailsDTO findByMealId(@PathVariable Integer id) {
        return mealDetailsService.findByMealId(id);
    }

    @PostMapping
    public FoodConsumedDTO addMealDetails(@RequestBody MealDetailsRequestDTO mealDetailsRequest) {
        return mealDetailsService.addMealDetails(mealDetailsRequest);
    }

    @PostMapping("/batch")
    public List<FoodConsumedDTO> addMealDetails(@RequestBody List<MealDetailsRequestDTO> mealDetailsRequest) {
        return mealDetailsService.addMealDetailsFromList(mealDetailsRequest);
    }

}
