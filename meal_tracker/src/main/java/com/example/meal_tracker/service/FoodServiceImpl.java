package com.example.meal_tracker.service;

import com.example.meal_tracker.dto.FoodDTO;
import com.example.meal_tracker.mapping.Mapper;
import com.example.meal_tracker.model.Food;
import com.example.meal_tracker.repository.FoodRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public List<FoodDTO> getAllFoods() {
        return foodRepository.findAll()
                .stream()
                .map(Mapper::foodToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FoodDTO getFoodById(Integer id) {
        Food food =  foodRepository.findById(id).get();
        return Mapper.foodToDTO(food);
    }

    @Override
    @Transactional
    public FoodDTO createFood(Food food) {
        Food foodSaved = foodRepository.save(food);
        return Mapper.foodToDTO(foodSaved);
    }
}
