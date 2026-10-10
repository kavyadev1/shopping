package com.example.product_service;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

       @Entity                             // blank 1: this class is a table
public class Product {

       @Id                          // blank 2: this field is the primary key
       @GeneratedValue(strategy = GenerationType.IDENTITY)                             // blank 3: MySQL generates the number
    private Long id;

    private String name;

    private BigDecimal price;

    private Integer quantity;            // blank 4: which type for a whole number?
}