package com.geekbrains.repository;

import com.geekbrains.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryInMem implements ProductRepository {
    private Map<String, Product> products = new HashMap<>();

    @Override
    public void insert(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void remove(Product product) {
        products.remove(product.getId());
    }

    @Override
    public Product findById(String id) {
        return products.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }
}
