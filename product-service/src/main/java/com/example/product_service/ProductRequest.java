package com.example.product_service;

import java.math.BigDecimal;
public class ProductRequest{
   private  String name;
   private  Integer quantity;
   private  BigDecimal price;

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
}