package com.example.demo.user;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import java.util.*

interface UserRepository: JpaRepository<User, Long> , JpaSpecificationExecutor<User> {
    fun findByLogin(login: String): User?
}