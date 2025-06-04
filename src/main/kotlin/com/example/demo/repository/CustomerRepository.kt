package com.example.demo.repository;

import com.example.demo.domain.entities.Customer
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import java.util.Optional

interface CustomerRepository : JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

    @EntityGraph(attributePaths = ["user.userRoles"])
    fun findForCustomerRegById(id: Long): Optional<Customer>
}