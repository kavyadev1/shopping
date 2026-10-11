package com.example.product_service;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

       @Entity                            
public class Product {

       @Id                          
       @GeneratedValue(strategy = GenerationType.IDENTITY)                         
    private Long id;  
    public Long getId(){
        return id;
    }  
    public void setId(Long id){
        this.id = id; 
    }

    private String name;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    private BigDecimal price;
    public BigDecimal getPrice (){
        return price;
    }
    public void setPrice(BigDecimal price){
        this.price = price;
    }

    private Integer quantity;    
    public Integer getQuantity (){
        return quantity;
    } 
    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }     
}