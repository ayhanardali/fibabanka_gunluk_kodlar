package com.example.fibabootcamp1.service;

import com.example.fibabootcamp1.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Override
    public Product find(long productId) {
        Product product = new Product(productId, "Cep Telefonu", 1450);
        System.out.println("İşgörü çalıştı.");
        return product;
    }
}
