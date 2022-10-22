package com.geekbrains.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Product {
    private String id;
    private String name;
    private long price;

    public Product(String name, long price) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
    }
}
