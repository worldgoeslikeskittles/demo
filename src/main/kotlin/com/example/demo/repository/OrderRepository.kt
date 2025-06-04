package com.example.demo.repository;

import com.example.demo.domain.entities.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface OrderRepository : JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {
}