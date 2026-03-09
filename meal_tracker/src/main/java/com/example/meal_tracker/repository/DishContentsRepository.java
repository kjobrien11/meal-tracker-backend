package com.example.meal_tracker.repository;

import com.example.meal_tracker.model.DishContents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishContentsRepository extends JpaRepository<DishContents, Integer> {
}
