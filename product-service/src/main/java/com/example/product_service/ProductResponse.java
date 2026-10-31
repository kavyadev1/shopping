package com.example.product_service;
import java.math.BigDecimal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
public class ProductResponse{
   private  String name;
   private  Integer quantity;
   private  BigDecimal price;
   private Long id;
public String getName(){
    return name;
}
public void setName(String name){
    this.name = name;
}

public Integer getQuantity(){
    return quantity;
}

public void setQuantity(Integer quantity){
    this.quantity = quantity;
}

public BigDecimal getPrice(){
    return price;
}

public void setPrice(BigDecimal price){
    this.price= price;
}


   public  Long getId(){
    return id;
   }

   public void setId(Long id){
    this.id = id;
   }
}