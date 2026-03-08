package com.example.meal_tracker.service;

import com.example.meal_tracker.model.Food;
import com.example.meal_tracker.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    @Override
    public Food getFoodById(Integer id) {
        return foodRepository.findById(id).get();
    }

    @Override
    public Food createFood(Food food) {
        return foodRepository.save(food);
    }
}
