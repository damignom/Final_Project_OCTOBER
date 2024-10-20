package com.example.Final_Project_OCTOBER.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    private Long productPrice;

    @ManyToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private List<Order> orders;
}
