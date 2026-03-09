package com.example.meal_tracker.controller;

import com.example.meal_tracker.dto.DishDTO;
import com.example.meal_tracker.model.Dish;
import com.example.meal_tracker.model.DishContents;
import com.example.meal_tracker.service.DishContentsService;
import com.example.meal_tracker.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    @Autowired
    DishContentsService dishContentsService;

    @GetMapping
    public List<DishDTO> getAllDishContents() {
        return dishService.getAllDishes();
    }
}
