package com.example.demo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.web.SecurityFilterChain
import java.lang.Exception

@Configuration
@EnableWebSecurity
class WebSecurityConfiguration() {
    @Throws(Exception::class)
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.authorizeHttpRequests { authorizeHttpRequests ->
            authorizeHttpRequests
                .anyRequest().permitAll()
        }
        http.headers(Customizer.withDefaults())
        http.sessionManagement(Customizer.withDefaults())
        http.formLogin(Customizer.withDefaults())
        http.anonymous(Customizer.withDefaults())
        http.csrf(Customizer.withDefaults())
        return http.build()
    }
}