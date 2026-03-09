package com.example.meal_tracker.controller;

import com.example.meal_tracker.dto.FoodConsumedDTO;
import com.example.meal_tracker.dto.MealContentsDTO;
import com.example.meal_tracker.dto.MealContentsRequestDTO;
import com.example.meal_tracker.service.MealContentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meal-details")
public class MealContentsController {

    @Autowired
    private MealContentsService mealContentsService;

    @GetMapping("/{id}")
    public MealContentsDTO findByMealId(@PathVariable Integer id) {
        return mealContentsService.findByMealId(id);
    }

    @PostMapping
    public FoodConsumedDTO addMealContents(@RequestBody MealContentsRequestDTO mealContentsRequest) {
        return mealContentsService.addMealContents(mealContentsRequest);
    }

    @PostMapping("/batch")
    public List<FoodConsumedDTO> addMealContents(@RequestBody List<MealContentsRequestDTO> mealContentsRequest) {
        return mealContentsService.addMealContentsFromList(mealContentsRequest);
    }

}
