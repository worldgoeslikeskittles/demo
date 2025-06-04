package com.example.demo.repository;

import com.example.demo.domain.entities.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface ProductRepository : JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
}