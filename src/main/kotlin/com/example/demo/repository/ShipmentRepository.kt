package com.example.demo.repository;

import com.example.demo.domain.entities.Shipment
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ShipmentRepository : JpaRepository<Shipment, Long> {
    fun findShipmentByOrderId(orderId: Long): Optional<Shipment>
}