package com.example.demo.customer

import com.example.demo.user.User
import com.example.demo.order.Order
import jakarta.persistence.*

@Entity
@Table(name = "customer")
class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq")
    @Column(name = "id", nullable = false)
     var id: Long? = null

    @OneToOne(fetch = FetchType.LAZY, optional = false, orphanRemoval = true)
    @JoinColumn(name = "user_id", nullable = false)
     var user: User? = null

    @OneToMany(mappedBy = "customer", orphanRemoval = true)
     var orders: MutableSet<Order> = mutableSetOf()
}