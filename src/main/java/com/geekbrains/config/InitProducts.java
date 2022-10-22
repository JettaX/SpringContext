package com.geekbrains.config;

import com.geekbrains.entity.Product;
import com.geekbrains.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitProducts {

    @Autowired
    private void setProductRepository(ProductRepository productRepositoryInMem) {
        productRepositoryInMem.insert(new Product("orange", 10));
        productRepositoryInMem.insert(new Product("apple", 23));
        productRepositoryInMem.insert(new Product("banana", 12));
        productRepositoryInMem.insert(new Product("grape", 5));
        productRepositoryInMem.insert(new Product("watermelon", 7));
        productRepositoryInMem.insert(new Product("raspberry", 13));
        productRepositoryInMem.insert(new Product("blueberry", 34));
        productRepositoryInMem.insert(new Product("blackberry", 19));
        productRepositoryInMem.insert(new Product("cherry", 23));
        productRepositoryInMem.insert(new Product("melon", 12));
    }
}
