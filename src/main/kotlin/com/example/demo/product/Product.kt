package com.example.demo.product

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "product")
 class Product(
   @Column(name = "name", nullable = false)
   var name: String,

   @Column(name = "price", precision = 19, scale = 2)
   var price: BigDecimal,

   @Column(name = "description", length = 4000)
   var description: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @SequenceGenerator(name = "product_seq")
    @Column(name = "id", nullable = false)
    var id: Long? = null

   @Enumerated(EnumType.STRING)
    @Column(name = "product_discount")
    var productDiscount: ProductDiscount? = null
}