package com.example.peliculas.repository

import com.example.peliculas.entity.Scene
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SceneRepository : JpaRepository<Scene, Long> {
    fun findAllByFilmId(filmId: Long): List<Scene>
}
