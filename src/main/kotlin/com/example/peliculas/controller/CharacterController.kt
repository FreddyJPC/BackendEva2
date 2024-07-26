package com.example.peliculas.controller

import com.example.peliculas.entity.Character
import com.example.peliculas.entity.CharacterDto
import com.example.peliculas.service.CharacterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/characters")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class CharacterController {

    @Autowired
    lateinit var characterService: CharacterService

    @GetMapping
    fun list(): List<Character> {
        return characterService.list()
    }

    @PostMapping
    fun save(@RequestBody characterDto: CharacterDto): Character {
        return characterService.save(characterDto)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody characterDto: CharacterDto): Character {
        return characterService.update(id, characterDto)
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
