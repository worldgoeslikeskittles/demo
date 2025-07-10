package com.example.demo.storage

import com.example.demo.storageitem.StorageItem
import jakarta.persistence.*

@Entity
@Table(name = "storage")
class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "storage_seq")
    @SequenceGenerator(name = "storage_seq")
    @Column(name = "id", nullable = false)
     var id: Long? = null

    @Column(name = "storage_number", nullable = false)
     var storageNumber: String? = null

    @OneToMany(mappedBy = "storage", orphanRemoval = true)
     var storageItems: MutableSet<StorageItem> = mutableSetOf()
}