package com.example.demo.order;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface OrderRepository : JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {
}