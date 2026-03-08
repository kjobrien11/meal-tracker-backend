package com.example.meal_tracker.repository;

import com.example.meal_tracker.model.MealDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealDetailsRepository extends JpaRepository<MealDetails, Long> {
    List<MealDetails> findAllByMeal_Id(Integer mealId);
}
