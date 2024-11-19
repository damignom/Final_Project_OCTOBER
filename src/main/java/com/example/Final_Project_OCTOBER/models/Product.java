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

    private String productFilename;



    private Long productPrice;

    @ManyToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private List<Order> orders;

    public Product() {
    }

    public Product(String productName, ProductType productType, Long productPrice) {
        this.productName = productName;
        this.productType = productType;
        this.productPrice = productPrice;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return productType.getTypeName();
    }

    public Long getProductPrice() {
        return productPrice;
    }

    public String getProductFilename() {
        return productFilename;
    }

    public void setProductFilename(String productFilename) {
        this.productFilename = productFilename;
    }
}
