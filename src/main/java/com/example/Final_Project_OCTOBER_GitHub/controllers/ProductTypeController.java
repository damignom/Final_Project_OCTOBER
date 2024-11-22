package com.example.Final_Project_OCTOBER_GitHub.controllers;

import com.example.Final_Project_OCTOBER_GitHub.models.ProductType;
import com.example.Final_Project_OCTOBER_GitHub.repository.ProductRepository;
import com.example.Final_Project_OCTOBER_GitHub.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProductTypeController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @GetMapping("/productType")
    public String allProductTypes(Model model){
        Iterable<ProductType> productTypeRepositories = productTypeRepository.findAll();
        model.addAttribute("productTypes", productTypeRepositories);

        return "addProductType";
    }

    @PostMapping("/productType/addType")
    public String addProductType(@RequestParam String productTypeName, @RequestParam String productTypeDescription, Model model ){

        ProductType productType = new ProductType(productTypeName);
        productType.setShortDescription(productTypeDescription);

        productTypeRepository.save(productType);

        Iterable<ProductType> productTypeRepositories = productTypeRepository.findAll();
        model.addAttribute("productTypes", productTypeRepositories);

        return "addProductType";
    }

    @PostMapping("/productType/deleteType")
    public String addProductType(@RequestParam Long productTypeId, Model model){

        System.out.println(productTypeId);

        productTypeRepository.deleteById(productTypeId);

        Iterable<ProductType> productTypeRepositories = productTypeRepository.findAll();
        model.addAttribute("productTypes", productTypeRepositories);

        return "addProductType";
    }

}
