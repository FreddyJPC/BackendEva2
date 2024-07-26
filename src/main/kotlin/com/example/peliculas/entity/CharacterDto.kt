package com.example.peliculas.entity


data class CharacterDto(
    val description: String,
    val cost: Double,
    val stock: Int,
    val scene_id: Long
)