package com.example.peliculas.controller

import com.example.peliculas.entity.Character
import com.example.peliculas.service.CharacterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/character")
class CharacterController {

    @Autowired
    lateinit var characterService: CharacterService

    @GetMapping
    fun list(): List<Character> {
        return characterService.list()
    }

    @PostMapping
    fun save(@RequestBody character: Character): Character {
        return characterService.save(character)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody character: Character): Character {
        return characterService.update(id, character)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        characterService.delete(id)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Character {
        return characterService.getById(id)
    }

    @PatchMapping("/{id}")
    fun partialUpdate(@PathVariable id: Long, @RequestBody partialCharacter: Map<String, Any>): Character {
        return characterService.partialUpdate(id, partialCharacter)
    }
}
