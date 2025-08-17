package org.example.springtest.service;

import org.example.springtest.model.dto.request.ProductRequest;
import org.example.springtest.model.entity.Product;

public interface ProductService {
    Product getProductById(Long id);

    Product createProduct(ProductRequest productRequest);
}
