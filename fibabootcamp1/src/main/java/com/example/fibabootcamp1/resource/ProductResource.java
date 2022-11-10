package com.example.fibabootcamp1.resource;

import com.example.fibabootcamp1.Product;
import com.example.fibabootcamp1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping("/api/product/{id}")
    public Product getProduct(@PathVariable("id") long productId)
    {
        Product product = productService.find(productId);
        return product;
    }

    @GetMapping("/api/products")
    public List<Product> getProducts()
    {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(301, "Cep Telefonu", 1450));
        productList.add(new Product(302, "Dizüstü Bilgisayar", 6575));
        productList.add(new Product(303, "Masaüstü Bilgisayar", 3490));
        return productList;
    }

    @PostMapping("/api/product")
    public Product postProduct(@RequestBody Product product)
    {
        product.setProductId(301);
        System.out.println("Ürün eklendi: " + product.getProductId() + " " + product.getProductName() + " " + product.getSalesPrice());
        return product;
    }

    @PutMapping("/api/product")
    public void putProduct(@RequestBody Product product)
    {
        System.out.println("Ürün güncellendi: " + product.getProductId() + " " + product.getProductName() + " " + product.getSalesPrice());
    }

    @DeleteMapping("/api/product/{id}")
    public void deleteProduct(@PathVariable("id") long productId)
    {
        System.out.println("Ürün silindi: " + productId);
    }
}
