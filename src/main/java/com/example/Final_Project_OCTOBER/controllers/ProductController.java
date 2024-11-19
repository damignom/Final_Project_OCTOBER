package com.example.Final_Project_OCTOBER.controllers;

import com.example.Final_Project_OCTOBER.models.Product;
import com.example.Final_Project_OCTOBER.models.ProductType;
import com.example.Final_Project_OCTOBER.repository.ProductRepository;
import com.example.Final_Project_OCTOBER.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/product")
    public String allProduct(Model model){
        Iterable<ProductType> productTypeRepositories = productTypeRepository.findAll();
        model.addAttribute("productTypes", productTypeRepositories);

        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("products", products);

        return "addProduct";
    }

    @PostMapping("/product/addProduct")
    public String addProduct(@RequestParam String productName, @RequestParam ProductType productType, @RequestParam Long productPrice,
                             @RequestParam MultipartFile productFile,  Model model) throws IOException {



        Product product = new Product(productName, productType, productPrice);

        if (productFile != null){
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()){
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + productFile.getOriginalFilename();

            productFile.transferTo(new File(uploadPath + "/" + resultFilename));

            product.setProductFilename(resultFilename);
        }

        productRepository.save(product);


        Iterable<ProductType> productTypeRepositories = productTypeRepository.findAll();
        model.addAttribute("productTypes", productTypeRepositories);

        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("products", products);

        return "addProduct";
    }

    @PostMapping("/product/deleteProduct")
    public String deleteProduct(@RequestParam Long productId, Model model)
    {
        System.out.println(productId);

        productRepository.deleteById(productId);

        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("products", products);

        Iterable<ProductType> productTypeRepositories = productTypeRepository.findAll();
        model.addAttribute("productTypes", productTypeRepositories);

        return "addProduct";
    }
}
