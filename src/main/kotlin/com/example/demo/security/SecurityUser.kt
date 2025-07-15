package com.example.demo.security

import com.example.demo.user.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.stream.Collectors


class SecurityUser(private val user: User) : UserDetails {

    override fun getUsername(): String {
        return user.login
    }

    override fun getPassword(): String {
        return user.password
    }

    override fun getAuthorities(): Collection<GrantedAuthority?> {
        return user.roles.map { SecurityAuthority(it.roleType) }
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}