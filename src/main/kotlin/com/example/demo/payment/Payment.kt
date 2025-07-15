package com.example.demo.payment

import com.example.demo.order.Order
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "payment")
class Payment{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_seq")
    @SequenceGenerator(name = "payment_seq")
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "cost", nullable = false, precision = 19, scale = 2)
    var cost: BigDecimal? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", nullable = false)
    var paymentStatus: PaymentStatus? = PaymentStatus.NOT_PAED

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    lateinit var order: Order
}