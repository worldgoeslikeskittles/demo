package com.example.demo.repository;

import com.example.demo.domain.entities.StorageItem
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository

interface StorageItemRepository : JpaRepository<StorageItem, Long> {

    @EntityGraph(attributePaths = ["storage"])
    fun findAllByStorageId(storageId:Long): List<StorageItem>
}