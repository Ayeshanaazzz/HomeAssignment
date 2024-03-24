package com.assignment.repository;

import com.assignment.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

    // Find products by category and brand
    List<Product> findByCategoryAndBrand(String category, String brand, Pageable pageable);

    // Find products by category
    List<Product> findByCategory(String category, Pageable pageable);

    // Find products by brand
    List<Product> findByBrand(String brand, Pageable pageable);

}
