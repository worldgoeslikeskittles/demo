package com.example.demo.department

import com.example.demo.user.User
import jakarta.persistence.*

@Entity
@Table(name = "department")
class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_seq")
    @SequenceGenerator(name = "department_seq")
    @Column(name = "id", nullable = false)
     var id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "manager_id", nullable = false)
     var manager: User? = null

    @Column(name = "name", nullable = false)
     var name: String? = null
}