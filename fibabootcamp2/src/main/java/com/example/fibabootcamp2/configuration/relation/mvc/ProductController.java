package com.example.fibabootcamp2.configuration.relation.mvc;

import com.example.fibabootcamp2.configuration.relation.entity.Product;
import com.example.fibabootcamp2.configuration.relation.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping("/inventory")
public class ProductController {

    //@Autowired
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/product/insert")
    @ResponseBody
    public String insertProduct() {
        Product product = new Product(0, "Cep Telefonu", 1000);
        productRepository.save(product);
        return "Ekleme başarılı: " + product.getProductId();
    }

    @GetMapping("/product/find")
    @ResponseBody
    public String findProduct() {
        long productId = 1;
        Optional<Product> optional = productRepository.findById(productId);
        if (optional.isPresent()) {
            Product product = optional.get();
            System.out.println(product.getProductId() + " " + product.getProductName() + " " + product.getSalesPrice());
            return "Ürün bulundu: " + product.getProductName();
        }
        return "Ürün bulunamadı";
    }

    @GetMapping("/product/list")
    @ResponseBody
    public String listProducts() {
        Iterable<Product> products = productRepository.findAll();
        int count = 0;
        for (Product product : products) {
            System.out.println(product.getProductId()
                    + " "
                    + product.getProductName()
                    + " "
                    + product.getSalesPrice());
            count++;
        }
        return "Ürün sayısı: " + count;
    }

    @GetMapping("/product/expensive")
    @ResponseBody
    public String listExpensiveProducts() {
        double minPrice = 2000;
        Iterable<Product> products = productRepository.findBySalesPriceMin(minPrice);
        int count = 0;
        for (Product product : products) {
            System.out.println(product.getProductId()
                    + " "
                    + product.getProductName()
                    + " "
                    + product.getSalesPrice());
            count++;
        }
        return "Şu kadar ürün bulundu: " + count;
    }

    @GetMapping("/product/delete")
    @ResponseBody
    public String deleteProduct() {
        long productId = 4;
        if (!productRepository.existsById(productId))
            return "Ürün bulunamadı. " + productId;
        productRepository.deleteById(productId);
        return "Ürün silindi.";
    }
}
