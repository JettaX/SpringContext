package com.geekbrains.service;

import com.geekbrains.entity.Product;

import java.util.List;
import java.util.Map;

public interface CartService {

    void insert(Product product);

    void insert(String productId);

    List<Product> findAllUnique();

    Map<Product, Integer> findAll();

    void remove(Product product);

    void remove(String productId);

    void clear();
}
