package com.example.demo.product

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.math.BigDecimal

@Entity
@Table(name = "product")
open class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @SequenceGenerator(name = "product_seq")
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "name", nullable = false)
    var name: String? = null

    @Column(name = "description", length = 4000)
    var description: String? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "product_discount")
    var productDiscount: ProductDiscount? = null

    @Column(name = "price", precision = 19, scale = 2)
    var price: BigDecimal? = null
}