package com.example.meal_tracker.service;

import com.example.meal_tracker.model.Dish;
import com.example.meal_tracker.model.DishContents;
import com.example.meal_tracker.repository.DishContentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishContentsServiceImpl implements DishContentsService {

    @Autowired
    private DishContentsRepository dishContentsRepository;

    @Override
    public DishContents createDishContents(DishContents dishContents) {
        return dishContentsRepository.save(dishContents);
    }

    @Override
    public List<DishContents> getAllDishContents() {
        return dishContentsRepository.findAll();
    }
}
