package com.example.peliculas.repository

import com.example.peliculas.entity.Character
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface CharacterRepository : JpaRepository<Character, Long> {
    fun existsBySceneId(sceneId: Long): Boolean
    fun deleteBySceneId(sceneId: Long)
}

