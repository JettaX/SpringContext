package com.geekbrains.service;

import com.geekbrains.entity.Product;
import com.geekbrains.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Scope("prototype")
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final ProductRepository productRepositoryInMem;
    private Map<Product, Integer> products = new HashMap<>();

    @Override
    public void insert(Product product) {
        Objects.requireNonNull(product);
        if (products.containsKey(product)) {
            int count = products.get(product);
            products.replace(product, count + 1);
        } else {
            products.put(product, 1);
        }
    }

    @Override
    public void insert(String productId) {
        insert(productRepositoryInMem.findById(productId));
    }

    @Override
    public List<Product> findAllUnique() {
        return new ArrayList<>(products.keySet());
    }

    @Override
    public Map<Product, Integer> findAll() {
        return products;
    }

    @Override
    public void remove(Product product) {
        if (products.get(product) == 1) {
            products.remove(product);
        } else {
            int count = products.get(product);
            products.replace(product, count - 1);
        }
    }

    @Override
    public void remove(String productId) {
        products.entrySet().stream()
                .filter(p -> p.getKey().getId().equals(productId))
                .findFirst()
                .ifPresent(product -> remove(product.getKey()));
    }

    @Override
    public void clear() {
        products.clear();
    }
}
