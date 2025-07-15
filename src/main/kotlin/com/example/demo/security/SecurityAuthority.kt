package com.example.demo.security

import com.example.demo.role.RoleType
import org.springframework.security.core.GrantedAuthority

class SecurityAuthority(private val role: RoleType): GrantedAuthority {
    override fun getAuthority(): String {
        return role.name
    }
}