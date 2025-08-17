package org.example.springtest.repository;

import org.example.springtest.model.entity.Product;
import org.example.springtest.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
