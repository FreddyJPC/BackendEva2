package com.example.peliculas.repository

import com.example.peliculas.entity.ViewScene
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ViewSceneRepository : JpaRepository<ViewScene, Long> {
}