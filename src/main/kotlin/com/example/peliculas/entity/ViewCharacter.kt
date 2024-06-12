package com.example.peliculas.entity

import jakarta.persistence.*
import org.hibernate.annotations.Immutable

@Entity
@Immutable
@Table(name = "view_character")
data class ViewCharacter(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val description: String? = null,
    val cost: Double? = null,
    val stock: Int? = null,
    val sceneName: String? = null
)
