package com.example.peliculas.entity

import jakarta.persistence.*

@Entity
@Table(name = "character")
class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    var description: String? = null

    var cost: Double? = null
    var stock: Int? = null

    @ManyToOne
    @JoinColumn(name = "scene_id", nullable = false)
    var scene: Scene? = null
}
