package org.example.springtest.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.springtest.model.dto.request.ProductRequest;
import org.example.springtest.model.entity.Product;
import org.example.springtest.repository.ProductRepository;
import org.example.springtest.service.ProductService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    @Override
    public Product createProduct(ProductRequest productRequest) {
        return productRepository.save(productRequest.toEntity());
    }
}
