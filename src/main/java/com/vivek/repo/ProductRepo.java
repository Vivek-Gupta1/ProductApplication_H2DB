package com.vivek.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivek.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{
	
	

}
