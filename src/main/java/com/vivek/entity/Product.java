package com.vivek.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private  Integer id;
    
  @NotBlank(message = "Name is Required") 
  @Size(min = 3 ,max = 10 , message = "Name Should be 3-10 Character")
  private String name;
  
  @NotNull(message="Price is Required")
  @Positive(message="Price should be positive")
  private Double price;

  @NotNull(message="quantity is Required")
  @Positive(message="Price should be positive")
  private Integer quantity;
	
	
	
	
	
}
