package com.example.Final_Project_OCTOBER;

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

import java.util.Map;

@Controller
public class GreetingsController {

    @Autowired
    ProductTypeRepository productTypeRepository;

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public String main (Model model)
    {
        Iterable<ProductType> productTypes = productTypeRepository.findAll();
        model.addAttribute("productTypes", productTypes);

        return "test";
    }

    @GetMapping("catalog")
    private String catalog(Model model){

        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("products", products);

        return "catalog";
    }

    @GetMapping("cart")
    private String cart(Model model){

        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("products", products);

        return "cart";
    }


}
