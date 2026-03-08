package com.example.meal_tracker.repository;

import com.example.meal_tracker.model.MealFood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealFoodRepository extends JpaRepository<MealFood, Long> {
    List<MealFood> findAllByMeal_Id(Integer mealId);
}
