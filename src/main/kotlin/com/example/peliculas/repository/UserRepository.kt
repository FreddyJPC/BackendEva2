package com.example.peliculas.repository

import com.example.peliculas.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<UserEntity, String> {
    fun findByUsername(username: String): UserEntity
}
