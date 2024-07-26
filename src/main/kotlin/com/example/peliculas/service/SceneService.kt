package com.example.peliculas.service

import com.example.peliculas.entity.Scene
import com.example.peliculas.repository.CharacterRepository
import com.example.peliculas.repository.SceneRepository
import com.example.peliculas.repository.FilmRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class SceneService {

    @Autowired
    lateinit var sceneRepository: SceneRepository

    fun list(): List<Scene> {
        return sceneRepository.findAll()
    }

    fun save(scene: Scene): Scene {
        if (scene.filmId == null) {
            throw RuntimeException("filmId cannot be null")
        }
        return sceneRepository.save(scene)
    }

    fun update(id: Long, scene: Scene): Scene {
        val existingScene = sceneRepository.findById(id).orElseThrow { RuntimeException("Scene not found") }
        existingScene.description = scene.description
        existingScene.budget = scene.budget
        existingScene.minutes = scene.minutes
        existingScene.filmId = scene.filmId
        return sceneRepository.save(existingScene)
    }

    fun delete(id: Long) {
        sceneRepository.deleteById(id)
    }

    fun getById(id: Long): Scene {
        return sceneRepository.findById(id).orElseThrow { RuntimeException("Scene not found") }
    }

    fun partialUpdate(id: Long, partialScene: Map<String, Any>): Scene {
        val scene = sceneRepository.findById(id).orElseThrow { RuntimeException("Scene not found") }
        partialScene.forEach { (key, value) ->
            when (key) {
                "description" -> scene.description = value as String
                "budget" -> scene.budget = value as Double
                "minutes" -> scene.minutes = value as Int
                "filmId" -> scene.filmId = value as Long
            }
        }
        return sceneRepository.save(scene)
    }
}
