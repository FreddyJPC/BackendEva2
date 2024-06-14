package com.example.peliculas.repository

import com.example.peliculas.entity.Character
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface CharacterRepository : JpaRepository<Character, Long> {

    @Query("SELECT SUM(s.minutes) FROM Scene s WHERE s.film.id = :filmId")
    fun sumMinutesByFilmId(@Param("filmId") filmId: Int): Int
}
