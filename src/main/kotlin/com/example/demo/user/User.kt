package com.example.demo.user

import com.example.demo.role.Role
import com.example.demo.role.RoleType
import jakarta.persistence.*

@Entity
@Table(name = "user_")
 class User(
    @Column(name = "name", nullable = false)
    var name: String,

    @Column(name = "login", nullable = false)
    var login: String,

    @Column(name = "password", nullable = false)
    var password: String,

    @ManyToMany
    @JoinTable(
        name = "user__roles",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "roles_id")]
    )
    var roles: MutableSet<Role> = mutableSetOf(Role(RoleType.CUSTOMER))
) {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq")
    @Column(name = "id", nullable = false)
    var id: Long? = null
}