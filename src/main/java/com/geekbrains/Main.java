package com.geekbrains;

import com.geekbrains.entity.Product;
import com.geekbrains.repository.ProductRepository;
import com.geekbrains.repository.ProductRepositoryInMem;
import com.geekbrains.service.CartService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("com.geekbrains");

        ProductRepository productRepository = context.getBean(ProductRepositoryInMem.class);

        List<Product> products = productRepository.findAll();

        CartService cart1 = context.getBean(CartService.class);
        CartService cart2 = context.getBean(CartService.class);
        CartService cart3 = context.getBean(CartService.class);
        CartService cart4 = context.getBean(CartService.class);

        cart1.insert(products.get(0));
        cart1.insert(products.get(0));
        cart1.insert(products.get(1));
        cart1.insert(products.get(4));

        cart2.insert(products.get(2));
        cart2.insert(products.get(4));
        cart2.insert(products.get(4));

        cart3.insert(products.get(1));
        cart3.insert(products.get(1));

        cart4.insert(products.get(5));
        cart4.insert(products.get(6));

        System.out.println("________________________________________________________");
        System.out.println(cart1.findAllUnique());
        System.out.println(cart1.findAll());
        System.out.println("________________________________________________________");
        System.out.println(cart2.findAllUnique());
        System.out.println(cart2.findAll());
        System.out.println("________________________________________________________");
        System.out.println(cart3.findAllUnique());
        System.out.println(cart3.findAll());
        System.out.println("________________________________________________________");
        System.out.println(cart4.findAllUnique());
        System.out.println(cart4.findAll());
        System.out.println("________________________________________________________");




    }
}