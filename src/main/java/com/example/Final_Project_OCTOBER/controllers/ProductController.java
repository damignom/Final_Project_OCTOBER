package com.example.Final_Project_OCTOBER.controllers;

import com.example.Final_Project_OCTOBER.models.Product;
import com.example.Final_Project_OCTOBER.models.ProductType;
import com.example.Final_Project_OCTOBER.repository.ProductRepository;
import com.example.Final_Project_OCTOBER.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    /*@GetMapping("/product/add")
    public String addProduct(Model model){
        Iterable<ProductType> productTypeRepositories = productTypeRepository.findAll();
        model.addAttribute("productTypes", productTypeRepositories);
        return "addProduct";
    }*/

    @GetMapping("/product")
    public String allProduct(Model model){
        Iterable<ProductType> productTypeRepositories = productTypeRepository.findAll();
        model.addAttribute("productTypes", productTypeRepositories);
        return "addProduct";
    }

    @PostMapping("addProduct")
    public String addProduct(@RequestParam String productName, @RequestParam ProductType productType, @RequestParam Long productPrice, Model model){

        Product product = new Product(productName, productType, productPrice);
        productRepository.save(product);
        return "addProduct";
    }
}
