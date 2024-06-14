package com.example.peliculas.service

import com.example.peliculas.entity.Scene
import com.example.peliculas.repository.SceneRepository
import com.example.peliculas.repository.FilmRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SceneService {

    @Autowired
    lateinit var sceneRepository: SceneRepository

    @Autowired
    lateinit var filmRepository: FilmRepository

    fun list(): List<Scene> {
        return sceneRepository.findAll()
    }

    fun save(scene: Scene): Scene {
        // Obtener la película relacionada con la escena
        val film = filmRepository.findById(scene.filmId!!.toLong())
            .orElseThrow { EntityNotFoundException("No se encontró la película con el ID: ${scene.filmId}") }

        // Calcular la suma de los minutos de todas las escenas existentes para esta película
        val totalMinutes = sceneRepository.findAllByFilmId(scene.filmId!!.toLong()).sumOf { it.minutes ?: 0 }

        // Verificar si la suma de los minutos con la nueva escena supera la duración de la película
        if (totalMinutes + (scene.minutes ?: 0) > film.duration!!) {
            throw IllegalArgumentException("La suma de los minutos de las escenas supera la duración de la película")
        }

        return sceneRepository.save(scene)
    }

    fun saveScenes(scenes: List<Scene>) {
        if (scenes.isEmpty()) return

        val filmId = scenes.first().filmId!!.toLong()
        val film = filmRepository.findById(filmId.toLong())
            .orElseThrow { EntityNotFoundException("No se encontró la película con el ID: $filmId") }

        val totalMinutes = scenes.sumOf { it.minutes ?: 0 }

        val existingScenesMinutes = sceneRepository.findAllByFilmId(filmId).sumOf { it.minutes ?: 0 }

        if (existingScenesMinutes + totalMinutes > film.duration!!) {
            throw IllegalArgumentException("La suma de los minutos de las escenas supera la duración de la película")
        }

        scenes.forEach { sceneRepository.save(it) }
    }

    fun update(id: Long, scene: Scene): Scene {
        val existingScene = sceneRepository.findById(id)
            .orElseThrow { EntityNotFoundException("No se encontró la escena con el ID: $id") }

        existingScene.description = scene.description
        existingScene.budget = scene.budget
        existingScene.minutes = scene.minutes

        return sceneRepository.save(existingScene)
    }

    fun delete(id: Long) {
        val existingScene = sceneRepository.findById(id)
            .orElseThrow { EntityNotFoundException("No se encontró la escena con el ID: $id") }

        sceneRepository.delete(existingScene)
    }

    fun getById(id: Long): Scene {
        return sceneRepository.findById(id)
            .orElseThrow { EntityNotFoundException("No se encontró la escena con el ID: $id") }
    }

    fun partialUpdate(id: Long, partialScene: Map<String, Any>): Scene {
        val existingScene = sceneRepository.findById(id)
            .orElseThrow { EntityNotFoundException("No se encontró la escena con el ID: $id") }

        partialScene.forEach { (key, value) ->
            when (key) {
                "description" -> existingScene.description = value as String
                "budget" -> existingScene.budget = value as Double?
                "minutes" -> existingScene.minutes = value as Int
                else -> throw IllegalArgumentException("Campo no válido para actualización parcial: $key")
            }
        }

        return sceneRepository.save(existingScene)
    }
}
