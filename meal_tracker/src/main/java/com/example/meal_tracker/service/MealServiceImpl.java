package com.example.meal_tracker.service;

import com.example.meal_tracker.dto.MealDTO;
import com.example.meal_tracker.mapping.Mapper;
import com.example.meal_tracker.model.Meal;
import com.example.meal_tracker.repository.MealRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MealServiceImpl implements MealService {

    @Autowired
    private MealRepository mealRepository;

    @Override
    public List<MealDTO> getMeals() {
        return mealRepository.findAll()
                .stream()
                .map(Mapper::mealToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MealDTO> getMealsForDate(LocalDate date) {
        return mealRepository.findAllByDate(date)
                .stream()
                .map(Mapper::mealToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MealDTO createMeal(Meal meal) {
        Meal mealSaved =  mealRepository.save(meal);
        return Mapper.mealToDTO(mealSaved);
    }

    @Override
    public MealDTO getMealById(Integer id) {
        Meal mealFound = mealRepository.findById(id).get();
        return Mapper.mealToDTO(mealFound);
    }
}
