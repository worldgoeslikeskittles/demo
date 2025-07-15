package com.example.demo.shipment

import com.example.demo.order.Order
import jakarta.persistence.*

@Entity
@Table(name = "shipment")
class Shipment(
    @Column(name = "delivery_address", nullable = false)
    var deliveryAddress: String
){
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shipment_seq")
    @SequenceGenerator(name = "shipment_seq")
    @Column(name = "id", nullable = false)
     var id: Long? = null

    @Column(name = "shipment_status", nullable = false)
    @Enumerated(EnumType.STRING)
    var shipmentStatus: ShipmentStatus = ShipmentStatus.NOT_STARTED

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, optional = false)
    @JoinColumn(name = "order_id", nullable = false, referencedColumnName = "id")
    lateinit var order: Order
}