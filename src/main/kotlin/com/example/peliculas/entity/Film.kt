package com.example.peliculas.entity

import jakarta.persistence.*

@Entity
@Table(name = "film")
data class Film(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    var title: String,
    var director: String,
    var duration: Int
)
