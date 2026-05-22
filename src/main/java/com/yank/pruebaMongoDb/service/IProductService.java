package com.yank.pruebaMongoDb.service;

import java.util.List;

import com.yank.pruebaMongoDb.dto.request.PriceRangeRequest;
import com.yank.pruebaMongoDb.dto.request.ProductRequest;
import com.yank.pruebaMongoDb.dto.response.ProductResponse;

public interface IProductService {
    /**
     * Create a new product.
     * 
     * @param request Product creation request data.
     * @return Created product response.
     */
    ProductResponse create(ProductRequest request);

    /**
     * Retrieve all active products.
     * 
     * @return List of product responses.
     */
    List<ProductResponse> findAll();

    /**
     * Retrieve a product by ID.
     * 
     * @param id Product identifier.
     * @return Product response.
     */
    ProductResponse findById(String id);

    /**
     * Find products inside the requested price range.
     * 
     * @param request Price range search criteria.
     * @return List of product responses.
     */
    List<ProductResponse> findByPriceRange(PriceRangeRequest request);

    /**
     * Find products by partial name match.
     * 
     * @param name Name text to search for.
     * @return List of matching product responses.
     */
    List<ProductResponse> findByName(String name);

    /**
     * Delete a product by ID.
     * 
     * @param id Product identifier.
     */
    void delete(String id);

    /**
     * Update an existing product.
     * 
     * @param id      Product identifier.
     * @param request Product update request data.
     * @return Updated product response.
     */
    ProductResponse update(String id, ProductRequest request);
}
