package org.example.springtest.controller;

import lombok.RequiredArgsConstructor;
import org.example.springtest.model.entity.Product;
import org.example.springtest.model.entity.User;
import org.example.springtest.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;
    @GetMapping("/{id}")
    public Product get(@PathVariable long id) {
        return productService.getProductById(id);
    }
}
