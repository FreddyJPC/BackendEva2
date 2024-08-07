package com.example.peliculas.repository

import com.example.peliculas.entity.Film
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FilmRepository : JpaRepository<Film, Long> {
    override fun existsById(id: Long): Boolean
    override fun deleteById(id: Long)
}
