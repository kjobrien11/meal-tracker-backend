package com.example.meal_tracker.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Food")
@Getter
@Setter
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(name = "calories_per_gram", nullable = false, precision = 6, scale = 3)
    private BigDecimal caloriesPerGram;

    @Column(name = "protein_per_gram", nullable = true, precision = 6, scale = 3)
    private BigDecimal proteinPerGram;

    @Column(name = "fat_per_gram", nullable = true, precision = 6, scale = 3)
    private BigDecimal fatPerGram;

    @Column(name = "carbs_per_gram", nullable = true, precision = 6, scale = 3)
    private BigDecimal carbsPerGram;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();


}
