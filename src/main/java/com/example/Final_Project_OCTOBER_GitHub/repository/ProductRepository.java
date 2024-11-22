package com.example.Final_Project_OCTOBER_GitHub.repository;

import com.example.Final_Project_OCTOBER_GitHub.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository <Product, Long> {

    //Product findByPrice(Long productPrice);
}
