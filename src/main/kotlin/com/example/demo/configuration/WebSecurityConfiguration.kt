package com.example.demo.configuration

import com.example.demo.security.JPAUserDetalisService
import com.example.demo.user.UserRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import java.lang.Exception

@Configuration
@EnableWebSecurity
class WebSecurityConfiguration(private val userRepository: UserRepository, private val jPAUserDetalisService: JPAUserDetalisService) {
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
        http.userDetailsService(jPAUserDetalisService)
        http.anonymous(Customizer.withDefaults())
        http.csrf(Customizer.withDefaults())
        return http.build()
    }

}