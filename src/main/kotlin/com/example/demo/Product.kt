package com.example.demo

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Product(
    @Id @GeneratedValue val id: Long? = null,
    val name: String,
    val price: Double,
    val quantity: Float,
    val createdDate: LocalDateTime = LocalDateTime.now()
)