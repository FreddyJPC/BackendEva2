package com.example.peliculas.service

import com.example.peliculas.entity.Character
import com.example.peliculas.entity.CharacterDto
import com.example.peliculas.repository.CharacterRepository
import com.example.peliculas.repository.SceneRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CharacterService {

    @Autowired
    lateinit var characterRepository: CharacterRepository

    @Autowired
    lateinit var sceneRepository: SceneRepository

    fun list(): List<Character> {
        return characterRepository.findAll()
    }

    fun save(characterDto: CharacterDto): Character {
        val scene = sceneRepository.findById(characterDto.scene_id)
            .orElseThrow { RuntimeException("Scene not found") }

        val character = Character().apply {
            description = characterDto.description
            cost = characterDto.cost
            stock = characterDto.stock
            this.scene = scene
        }

        return characterRepository.save(character)
    }

    fun update(id: Long, characterDto: CharacterDto): Character {
        val existingCharacter = characterRepository.findById(id).orElseThrow { RuntimeException("Character not found") }
        val scene = sceneRepository.findById(characterDto.scene_id)
            .orElseThrow { RuntimeException("Scene not found") }

        existingCharacter.apply {
            description = characterDto.description
            cost = characterDto.cost
            stock = characterDto.stock
            this.scene = scene
        }

        return characterRepository.save(existingCharacter)
    }

    fun delete(id: Long) {
        characterRepository.deleteById(id)
    }

    fun getById(id: Long): Character {
        return characterRepository.findById(id).orElseThrow { RuntimeException("Character not found") }
    }

    fun partialUpdate(id: Long, partialCharacter: Map<String, Any>): Character {
        val character = characterRepository.findById(id).orElseThrow { RuntimeException("Character not found") }
        partialCharacter.forEach { (key, value) ->
            when (key) {
                "description" -> character.description = value as String
                "cost" -> character.cost = value as Double
                "stock" -> character.stock = value as Int
                // Manejo del campo 'scene_id' solo si está presente en la actualización parcial
                "scene_id" -> {
                    val sceneId = value as Long
                    val scene = sceneRepository.findById(sceneId)
                        .orElseThrow { RuntimeException("Scene not found") }
                    character.scene = scene
                }
            }
        }
        return characterRepository.save(character)
    }
}
