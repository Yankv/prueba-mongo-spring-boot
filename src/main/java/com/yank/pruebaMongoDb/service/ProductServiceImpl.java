package com.yank.pruebaMongoDb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yank.pruebaMongoDb.dto.request.PriceRangeRequest;
import com.yank.pruebaMongoDb.dto.request.ProductRequest;
import com.yank.pruebaMongoDb.dto.response.ProductResponse;
import com.yank.pruebaMongoDb.exception.ResourceNotFoundException;
import com.yank.pruebaMongoDb.mapper.ProductMapper;
import com.yank.pruebaMongoDb.model.Product;
import com.yank.pruebaMongoDb.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {
    private final ProductRepository repository;

    @Override
    public ProductResponse create(ProductRequest request) {
        Product product = ProductMapper.toEntity(request);

        return ProductMapper.toResponse(
                repository.save(product));
    }

    @Override
    public List<ProductResponse> findAll() {
        List<Product> products = repository.findAllByActiveTrue();
        if (products.isEmpty()) {
            throw new ResourceNotFoundException("No products found");
        }
        return ProductMapper.toResponsList(products);
    }

    @Override
    public ProductResponse findById(String id) {
        return ProductMapper.toResponse(
                repository.findByIdAndActiveTrue(id).orElseThrow(
                        () -> new ResourceNotFoundException("No product found with ID: " + id)));
    }

    @Override
    public List<ProductResponse> findByPriceRange(PriceRangeRequest request) {
        List<Product> products = repository.findByPriceBetweenAndActiveTrue(request.getMinPrice(), request.getMaxPrice());
        if (products.isEmpty()) {
            throw new ResourceNotFoundException("No products found in that price range");
        }
        return ProductMapper.toResponsList(products);
    }

    @Override
    public List<ProductResponse> findByName(String name) {
        List<Product> products = repository.findByNameContainingIgnoreCaseAndActiveTrue(name);
        if (products.isEmpty()) {
            throw new ResourceNotFoundException("No products found with the name: " + name);
        }
        return ProductMapper.toResponsList(products);
    }

    @Override
    public void delete(String id) {
        Product product = repository.findByIdAndActiveTrue(id).orElseThrow(
                () -> new ResourceNotFoundException("No product found with ID: " + id));

        product.setActive(false);

        repository.save(product);
    }

    @Override
    public ProductResponse update(String id, ProductRequest request) {
        Product product = repository.findByIdAndActiveTrue(id).orElseThrow(
                () -> new ResourceNotFoundException("No product found with ID: " + id));

        product.setName(request.name());
        product.setCategory(request.category());
        product.setPrice(request.price());
        product.setStock(request.stock());
        product.setTags(request.tags());

        Product updatedProduct = repository.save(product);

        return ProductMapper.toResponse(updatedProduct);
    }
}
