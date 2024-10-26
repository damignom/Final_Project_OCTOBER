package com.example.Final_Project_OCTOBER;

import com.example.Final_Project_OCTOBER.models.ProductType;
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
    @GetMapping("/greetings")
    public String greetings(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Model model
    ){
        model.addAttribute("name", name);
        return "greeting";
    }

    @Autowired
    ProductTypeRepository productTypeRepository;

    @GetMapping
    public String main (Model model)
    {
        Iterable<ProductType> productTypes = productTypeRepository.findAll();
        model.addAttribute("productTypes", productTypes);

        return "test";
    }

    @PostMapping
    public String addProductType(@RequestParam String typeName, Model model){

    ProductType productType = new ProductType(typeName);

    productTypeRepository.save(productType);

    Iterable<ProductType> productTypes = productTypeRepository.findAll();
        model.addAttribute("productTypes", productTypes);
        return "main";
    }

    @PostMapping("delete")
    public String delete(@RequestParam Long idType, Model model){
        System.out.println(idType);
        productTypeRepository.deleteById(idType);

        Iterable<ProductType> productTypes = productTypeRepository.findAll();
        model.addAttribute("productTypes", productTypes);
        return "main";
    }
}
