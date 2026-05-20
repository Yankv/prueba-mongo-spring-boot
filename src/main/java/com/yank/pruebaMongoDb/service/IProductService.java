package com.yank.pruebaMongoDb.service;

import java.util.List;

import com.yank.pruebaMongoDb.dto.request.PriceRangeRequest;
import com.yank.pruebaMongoDb.dto.request.ProductCreateRequest;
import com.yank.pruebaMongoDb.dto.request.ProductUpdateRequest;
import com.yank.pruebaMongoDb.dto.response.ProductResponse;

public interface IProductService {
    ProductResponse create(ProductCreateRequest request);

    List<ProductResponse> findAll();

    ProductResponse findById(String id);

    List<ProductResponse> findByPriceRange(PriceRangeRequest request);

    List<ProductResponse> findByName(String name);

    void delete(String id);

    ProductResponse update(String id, ProductUpdateRequest request);
}
