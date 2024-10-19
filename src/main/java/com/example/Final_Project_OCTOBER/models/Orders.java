package com.example.Final_Project_OCTOBER.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    private User userId;
    private Product productId;
    private OrderStatus orderStatusId;

}
