package com.example.meal_tracker.repository;

import com.example.meal_tracker.model.MealContents;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealContentsRepository extends JpaRepository<MealContents, Long> {
    List<MealContents> findAllByMeal_Id(Integer mealId);
}
