package com.example.peliculas.entity

import jakarta.persistence.*

@Entity
@Table(name = "film")
class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false, unique = true)
    var title: String? = null

    var director: String? = null
    var duration: Int? = null


}
