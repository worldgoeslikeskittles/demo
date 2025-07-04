package com.example.demo.department;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface DepartmentRepository : JpaRepository<Department, Long>, JpaSpecificationExecutor<Department> {
}