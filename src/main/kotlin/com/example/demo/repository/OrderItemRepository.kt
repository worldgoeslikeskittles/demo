package com.example.demo.repository;

import com.example.demo.domain.entities.OrderItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface OrderItemRepository : JpaRepository<OrderItem, Long> {
}