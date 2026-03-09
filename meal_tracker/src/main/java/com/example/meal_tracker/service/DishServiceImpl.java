package com.example.meal_tracker.service;

import com.example.meal_tracker.dto.CreateDishRequestDTO;
import com.example.meal_tracker.dto.DishDTO;
import com.example.meal_tracker.dto.FoodDTO;
import com.example.meal_tracker.mapping.Mapper;
import com.example.meal_tracker.model.Dish;
import com.example.meal_tracker.model.DishContents;
import com.example.meal_tracker.model.Food;
import com.example.meal_tracker.repository.DishContentsRepository;
import com.example.meal_tracker.repository.DishRepository;
import com.example.meal_tracker.repository.FoodRepository;
import jakarta.transaction.Transactional;
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

    @Autowired
    FoodRepository foodRepository;

    @Override
    @Transactional
    public DishDTO createDish(CreateDishRequestDTO createDishRequestDTO) {
        Dish dish = new Dish();
        dish.setName(createDishRequestDTO.name());
        Dish dishSaved =  dishRepository.save(dish);
        List<DishContents> contentsList = new ArrayList<>();
        List<FoodDTO> dishFoodsList = new ArrayList<>();

        for(Integer foodId : createDishRequestDTO.foodIds()) {
            DishContents dishContents = new DishContents();
            dishContents.setDish(dishSaved);
            Food food = foodRepository.getReferenceById(foodId);
            dishContents.setFood(food);

            contentsList.add(dishContents);

            dishFoodsList.add(Mapper.foodToDTO(food));
        }

        dishContentsRepository.saveAll(contentsList);

        return new DishDTO(dishSaved.getName(), dishFoodsList);

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
