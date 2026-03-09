package com.example.meal_tracker.repository;

import com.example.meal_tracker.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Integer> {
}
