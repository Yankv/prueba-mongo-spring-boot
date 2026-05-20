package com.yank.pruebaMongoDb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.yank.pruebaMongoDb.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    Optional<Product> findByIdAndActiveTrue(String id);

    List<Product> findAllByActiveTrue();

    List<Product> findByPriceBetweenAndActiveTrue(Double min, Double max);

    List<Product> findByNameContainingIgnoreCaseAndActiveTrue(String name);
}
