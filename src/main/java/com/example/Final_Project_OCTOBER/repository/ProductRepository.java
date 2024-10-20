package com.example.Final_Project_OCTOBER.repository;

import com.example.Final_Project_OCTOBER.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository <Product, Long> {

    //Product findByPrice(Long productPrice);
}
