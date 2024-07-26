package com.example.peliculas.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "scene")
class Scene {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    var description: String? = null

    var budget: Double? = null
    var minutes: Int? = null

    @Column(name = "film_id", nullable = false)
    var filmId: Long? = null  // Este campo es obligatorio y no puede ser nulo.
}