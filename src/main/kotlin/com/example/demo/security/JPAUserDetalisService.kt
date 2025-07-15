package com.example.demo.security;

import com.example.demo.user.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class JPAUserDetalisService(private val userRepository: UserRepository) : UserDetailsService {
    override fun loadUserByUsername(login: String): UserDetails {
       return userRepository.findByLogin(login)
           ?.let { SecurityUser(it) }
           ?: throw UsernameNotFoundException("Username not found $login" )
    }
}