package com.example.peliculas.entity

import jakarta.persistence.*
import org.hibernate.annotations.Immutable

@Entity
@Immutable
@Table(name = "scene_with_film_name")
data class ViewScene(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val description: String? = null,
    val budget: Double? = null,
    val minutes: Int? = null,
    val filmName: String? = null
)
