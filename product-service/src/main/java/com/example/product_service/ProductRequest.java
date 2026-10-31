package com.example.product_service;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;


public class ProductRequest{
    private String name;
    private BigDecimal price;
    private Integer quantity;
    @NotBlank(message = "Name is required")
    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than 0")
    @NotNull(message = "Quantity is required")
    @PositiveOrZero(message = "Quantity cannot be negative")
    

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