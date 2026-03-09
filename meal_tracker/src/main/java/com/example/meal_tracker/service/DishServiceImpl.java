package com.example.meal_tracker.service;

import com.example.meal_tracker.dto.DishDTO;
import com.example.meal_tracker.dto.FoodDTO;
import com.example.meal_tracker.mapping.Mapper;
import com.example.meal_tracker.model.Dish;
import com.example.meal_tracker.model.DishContents;
import com.example.meal_tracker.model.Food;
import com.example.meal_tracker.repository.DishContentsRepository;
import com.example.meal_tracker.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private DishContentsRepository dishContentsRepository;

    @Override
    public Dish createDish(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public List<DishDTO> getAllDishes() {
        List<Dish> dishes =  dishRepository.findAll();
        List<DishDTO> dishDTOs = new ArrayList<>();

        for (Dish dish : dishes) {
            dishDTOs.add(populateDishContents(dish));
        }

        return dishDTOs;
    }

    private DishDTO populateDishContents(Dish dish) {
        List<DishContents> dishContents = dishContentsRepository.findAllByDishId(dish.getId());
        List<FoodDTO> foodsInDish = new ArrayList<>();

        for (DishContents dishContent: dishContents) {
            foodsInDish.add(Mapper.foodToDTO(dishContent.getFood()));
        }

        return new DishDTO(dish.getName(), foodsInDish);
    }
}
