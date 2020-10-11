package com.springBoot.mySql.Crud.repository;

import com.springBoot.mySql.Crud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByName(String name);
}
