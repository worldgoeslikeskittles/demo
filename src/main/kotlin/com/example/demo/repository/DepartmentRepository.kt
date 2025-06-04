package com.example.demo.repository;

import com.example.demo.domain.entities.Department
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface DepartmentRepository : JpaRepository<Department, Long>, JpaSpecificationExecutor<Department> {
}