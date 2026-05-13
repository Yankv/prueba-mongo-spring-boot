package com.yank.pruebaMongoDb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yank.pruebaMongoDb.dto.ProductRequest;
import com.yank.pruebaMongoDb.dto.ProductResponse;
import com.yank.pruebaMongoDb.mapper.ProductMapper;
import com.yank.pruebaMongoDb.model.Product;
import com.yank.pruebaMongoDb.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository repository;

    @Override
    public ProductResponse create(ProductRequest request) {
        Product product = ProductMapper.toEntity(request);

        return ProductMapper.toResponse(
                repository.save(product));
    }

    @Override
    public List<ProductResponse> findAll() {
        return ProductMapper.toResponsList(
                repository.findAll());
    }
}
