package com.example.demo.user

import com.example.demo.department.Department
import jakarta.persistence.*

@Entity
@Table(name = "user_")
 class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq")
    @Column(name = "id", nullable = false)
    var id: Long? = null

   @Column(name = "name", nullable = false)
   var name: String? = null

   @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    var department: Department? = null

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    var userRoles: MutableSet<UserRole> = mutableSetOf()

    @OneToOne(mappedBy = "user", cascade = [CascadeType.ALL], optional = true, orphanRemoval = true)
    lateinit var userCredentials: UserCredentials
}