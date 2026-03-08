package com.example.meal_tracker.controller;

import com.example.meal_tracker.dto.MealDTO;
import com.example.meal_tracker.model.Meal;
import com.example.meal_tracker.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/meals")
public class MealController {

    @Autowired
    private MealService mealService;

    @GetMapping
    public List<MealDTO> getMeals() {
        return mealService.getMeals();
    }

    @GetMapping("/{id}")
    public MealDTO getMeal(@PathVariable Integer id) {
        return mealService.getMealById(id);
    }

    @GetMapping("/date/{date}")
    public List<MealDTO> getMealsForDay(@PathVariable String date) {
        LocalDate dateParsed = LocalDate.parse(date);
        return mealService.getMealsForDate(dateParsed);
    }

    @PostMapping
    public MealDTO createMeal(@RequestBody Meal meal) {
        return mealService.createMeal(meal);
    }
}
