package com.example.demo.storage;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface StorageRepository : JpaRepository<Storage, Long>, JpaSpecificationExecutor<Storage> {
}