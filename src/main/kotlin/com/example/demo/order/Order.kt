package com.example.demo.order

import com.example.demo.customer.Customer
import com.example.demo.orderitem.OrderItem
import com.example.demo.payment.Payment
import com.example.demo.shipment.Shipment
import jakarta.persistence.*
import org.hibernate.proxy.HibernateProxy

@Entity
@Table(name = "order_")
class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    @SequenceGenerator(name = "order_seq")
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    var customer: Customer? = null

    @OneToMany(mappedBy = "order", orphanRemoval = true)
    var orderItems: MutableSet<OrderItem> = mutableSetOf()

    @OneToOne(orphanRemoval = true, mappedBy = "order")
    var payment: Payment? = null

    @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true, mappedBy = "order" )
    var shipment: Shipment? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false)
    var orderStatus: OrderStatus? = null

    @Column(name = "order_number", nullable = false)
    var orderNumber: String? = null

    final override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null) return false
        val oEffectiveClass =
            if (other is HibernateProxy) other.hibernateLazyInitializer.persistentClass else other.javaClass
        val thisEffectiveClass =
            if (this is HibernateProxy) this.hibernateLazyInitializer.persistentClass else this.javaClass
        if (thisEffectiveClass != oEffectiveClass) return false
        other as Order

        return id != null && id == other.id
    }

    final override fun hashCode(): Int =
        if (this is HibernateProxy) this.hibernateLazyInitializer.persistentClass.hashCode() else javaClass.hashCode()
}