package com.example.demo.user

import com.example.demo.department.Department
import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
@Table(name = "user_")
open class User:UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq")
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    open var department: Department? = null

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    var userRoles: MutableSet<UserRole> = mutableSetOf()

    @OneToOne(mappedBy = "user", cascade = [CascadeType.ALL], optional = true, orphanRemoval = true)
    lateinit var userCredentials: UserCredentials

    @Column(name = "name")
    open var name: String? = null
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return userRoles.map { SimpleGrantedAuthority(it.role!!.name) }.toMutableList()
    }

    override fun getPassword(): String {
        return userCredentials.password
    }

    override fun getUsername(): String {
       return userCredentials.login
    }
}