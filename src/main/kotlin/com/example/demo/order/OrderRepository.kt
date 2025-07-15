package com.example.demo.order;

import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import java.util.*

interface OrderRepository : JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {
}