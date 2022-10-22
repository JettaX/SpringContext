package com.geekbrains.repository;

import com.geekbrains.entity.Product;

import java.util.List;

public interface ProductRepository {
    void insert(Product product);

    void remove(Product product);

    Product findById(String id);

    List<Product> findAll();
}
