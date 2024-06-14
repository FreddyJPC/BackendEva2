package com.example.peliculas.service

import com.example.peliculas.entity.Character
import com.example.peliculas.repository.CharacterRepository
import com.example.peliculas.repository.FilmRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CharacterService {

    @Autowired
    lateinit var characterRepository: CharacterRepository

    @Autowired
    lateinit var filmRepository: FilmRepository

    fun list(): List<Character> {
        return characterRepository.findAll()
    }

    fun save(character: Character): Character {
        return characterRepository.save(character)
    }

    fun update(id: Long, character: Character): Character {
        val existingCharacter = characterRepository.findById(id)
            .orElseThrow { EntityNotFoundException("No se encontró el personaje con el ID: $id") }

        existingCharacter.description = character.description
        existingCharacter.cost = character.cost
        existingCharacter.stock = character.stock

        return characterRepository.save(existingCharacter)
    }

    fun delete(id: Long) {
        val existingCharacter = characterRepository.findById(id)
            .orElseThrow { EntityNotFoundException("No se encontró el personaje con el ID: $id") }

        characterRepository.delete(existingCharacter)
    }

    fun getById(id: Long): Character {
        return characterRepository.findById(id)
            .orElseThrow { EntityNotFoundException("No se encontró el personaje con el ID: $id") }
    }

    fun partialUpdate(id: Long, partialCharacter: Map<String, Any>): Character {
        val existingCharacter = characterRepository.findById(id)
            .orElseThrow { EntityNotFoundException("No se encontró el personaje con el ID: $id") }

        partialCharacter.forEach { (key, value) ->
            when (key) {
                "description" -> existingCharacter.description = value as String
                "cost" -> existingCharacter.cost = value as Double?
                "stock" -> existingCharacter.stock = value as Int
                else -> throw IllegalArgumentException("Campo no válido para actualización parcial: $key")
            }
        }

        return characterRepository.save(existingCharacter)
    }

    fun checkFilmDurationAgainstTotalSceneMinutes(filmId: Long): Boolean {
        val film = filmRepository.findById(filmId)
            .orElseThrow { EntityNotFoundException("No se encontró la película con el ID: $filmId") }

        val totalMinutes = characterRepository.sumMinutesByFilmId(filmId.toInt())

        return totalMinutes <= film.duration!!
    }
}
