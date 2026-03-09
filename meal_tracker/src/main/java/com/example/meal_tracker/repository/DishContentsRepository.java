package com.example.meal_tracker.repository;

import com.example.meal_tracker.model.DishContents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishContentsRepository extends JpaRepository<DishContents, Integer> {
    List<DishContents> findAllByDishId(Integer dishId);
}
