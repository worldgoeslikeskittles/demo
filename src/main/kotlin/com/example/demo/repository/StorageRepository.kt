package com.example.demo.repository;

import com.example.demo.domain.entities.Storage
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface StorageRepository : JpaRepository<Storage, Long>, JpaSpecificationExecutor<Storage> {
}