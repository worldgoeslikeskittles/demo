package com.example.demo.product

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "product")
 class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @SequenceGenerator(name = "product_seq")
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "name", nullable = false)
    lateinit var name: String

    @Column(name = "price", precision = 19, scale = 2)
    lateinit var price: BigDecimal

    @Column(name = "description", length = 4000)
    lateinit var description: String

   @Enumerated(EnumType.STRING)
    @Column(name = "product_discount")
    var productDiscount: ProductDiscount? = null
}