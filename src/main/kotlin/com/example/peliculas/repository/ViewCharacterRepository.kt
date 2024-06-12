package com.example.peliculas.repository

import com.example.peliculas.entity.ViewCharacter
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ViewCharacterRepository : JpaRepository<ViewCharacter, Long> {
}
