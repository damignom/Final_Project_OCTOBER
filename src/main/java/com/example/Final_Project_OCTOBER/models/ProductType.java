package com.example.Final_Project_OCTOBER.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "productType")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String typeName;

    @OneToMany(mappedBy = "productType", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();
}
