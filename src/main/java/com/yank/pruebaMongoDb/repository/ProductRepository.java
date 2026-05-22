package com.yank.pruebaMongoDb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.yank.pruebaMongoDb.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    /**
     * Find a product by its ID only if it's active.
     * 
     * @param id The ID of the product to find.
     * @return Optional containing the product if found and active, or empty if not
     *         found or inactive.
     */
    Optional<Product> findByIdAndActiveTrue(String id);

    /**
     * Find all products that are active.
     * 
     * @return List of active products.
     */
    List<Product> findAllByActiveTrue();

    /**
     * Find active products whose price is between the given range.
     * 
     * @param min The minimum price.
     * @param max The maximum price.
     * @return List of active products in the price range.
     */
    List<Product> findByPriceBetweenAndActiveTrue(Double min, Double max);

    /**
     * Find active products whose name contains the given text, case-insensitive.
     * 
     * @param name The name text to search for.
     * @return List of matching active products.
     */
    List<Product> findByNameContainingIgnoreCaseAndActiveTrue(String name);
}
