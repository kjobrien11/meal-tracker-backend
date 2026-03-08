package com.example.meal_tracker.service;

import com.example.meal_tracker.dto.MealFoodDTO;
import com.example.meal_tracker.mapping.Mapper;
import com.example.meal_tracker.model.MealFood;
import com.example.meal_tracker.repository.MealFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MealFoodServiceImpl implements MealFoodService {

    @Autowired
    private MealFoodRepository mealFoodRepository;


    @Override
    public List<MealFoodDTO> findByMealId(Integer mealId) {
        return mealFoodRepository.findAllByMeal_Id(mealId)
                .stream()
                .map(Mapper::mealFoodToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MealFoodDTO createMealFood(MealFood mealFood) {
        MealFood mealFoodSaved = mealFoodRepository.save(mealFood);
        return Mapper.mealFoodToDTO(mealFoodSaved);
    }

    @Override
    public MealFoodDTO findMealFoodById(Long id) {
        MealFood mealFoodFound = mealFoodRepository.findById(id).orElse(null);
        return Mapper.mealFoodToDTO(mealFoodFound);
    }


}
