package com.example.meal_tracker.controller;

import com.example.meal_tracker.dto.CreateDishRequestDTO;
import com.example.meal_tracker.dto.DishDTO;
import com.example.meal_tracker.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping
    public List<DishDTO> getAllDishContents() {
        return dishService.getAllDishes();
    }

    @PostMapping
    public DishDTO createDish(@RequestBody CreateDishRequestDTO createDishRequestDTO) {
        return dishService.createDish(createDishRequestDTO);
    }
}
