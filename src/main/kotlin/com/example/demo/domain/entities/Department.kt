package com.example.demo.domain.entities

import jakarta.persistence.*

@Entity
@Table(name = "department")
class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_seq")
    @SequenceGenerator(name = "department_seq")
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "manager_id", nullable = false)
    open var manager: User? = null

    @Column(name = "name", nullable = false)
    open var name: String? = null
}