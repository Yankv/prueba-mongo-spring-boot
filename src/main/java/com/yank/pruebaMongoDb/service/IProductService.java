package com.yank.pruebaMongoDb.service;

import java.util.List;

import com.yank.pruebaMongoDb.dto.ProductRequest;
import com.yank.pruebaMongoDb.dto.ProductResponse;

public interface IProductService {
    ProductResponse create(ProductRequest request);

    List<ProductResponse> findAll();
}
