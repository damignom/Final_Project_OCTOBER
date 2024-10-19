package com.example.Final_Project_OCTOBER.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date orderDate;
    @ElementCollection(targetClass = OrderStatus.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "orderStatus", joinColumns = @JoinColumn(name = "orders_id"))
    @Enumerated(EnumType.STRING)
    private Set<OrderStatus> orderStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User customer;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE})
    @JoinTable(name = "order_products",
        joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;
}
