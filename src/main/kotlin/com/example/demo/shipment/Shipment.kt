package com.example.demo.shipment

import com.example.demo.order.Order
import jakarta.persistence.*

@Entity
@Table(name = "shipment")
 class Shipment(
    @OneToOne(fetch = FetchType.LAZY, optional = false, orphanRemoval = true)
    @JoinColumn(name = "order_id", nullable = false)
    var order: Order? = null,

    @Column(name = "delivery_address", nullable = false)
    var deliveryAddress: String? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "shipment_status", nullable = false)
    var shipmentStatus: ShipmentStatus? = ShipmentStatus.NOT_STARTED
) {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shipment_seq")
    @SequenceGenerator(name = "shipment_seq")
    @Column(name = "id", nullable = false)
     var id: Long? = null
}