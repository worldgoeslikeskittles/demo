package com.example.demo.storageitem

import com.example.demo.product.Product
import com.example.demo.storage.Storage
import jakarta.persistence.*
import org.hibernate.proxy.HibernateProxy

@Entity
@Table(name = "storage_item")
class StorageItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "storage_item_seq")
    @SequenceGenerator(name = "storage_item_seq")
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "storage_id", nullable = false)
    var storage: Storage? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    var product: Product? = null

    @Column(name = "count", nullable = false)
    var count: Long? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "storage_item_discount")
    var storageItemDiscount: StorageItemDiscount? = null

    final override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null) return false
        val oEffectiveClass =
            if (other is HibernateProxy) other.hibernateLazyInitializer.persistentClass else other.javaClass
        val thisEffectiveClass =
            if (this is HibernateProxy) this.hibernateLazyInitializer.persistentClass else this.javaClass
        if (thisEffectiveClass != oEffectiveClass) return false
        other as StorageItem

        return id != null && id == other.id
    }

    final override fun hashCode(): Int =
        if (this is HibernateProxy) this.hibernateLazyInitializer.persistentClass.hashCode() else javaClass.hashCode()
}