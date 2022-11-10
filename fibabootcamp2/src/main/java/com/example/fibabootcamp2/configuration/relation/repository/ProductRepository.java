package com.example.fibabootcamp2.configuration.relation.repository;

import com.example.fibabootcamp2.configuration.relation.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    //JPQL
    @Query("select p from Product as p where p.salesPrice >= :minPrice")
    List<Product> findBySalesPriceMin(@Param("minPrice") double minimumPrice);
}
