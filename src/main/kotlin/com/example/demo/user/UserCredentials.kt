package com.example.demo.user

import jakarta.persistence.*

@Entity
@Table(name = "user_credentials")
class UserCredentials {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_credentials_seq")
    @SequenceGenerator(name = "user_credentials_seq")
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @OneToOne(fetch = FetchType.LAZY, optional = true, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    lateinit var user: User

    @Column(name = "login", nullable = false)
    lateinit var login: String

    @Column(name = "password", nullable = false)
    lateinit var password: String
}