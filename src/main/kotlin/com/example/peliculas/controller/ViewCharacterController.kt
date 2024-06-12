package com.example.peliculas.controller

import com.example.peliculas.entity.ViewCharacter
import com.example.peliculas.service.ViewCharacterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/view-characters")
class ViewCharacterController {

    @Autowired
    lateinit var viewCharacterService: ViewCharacterService

    @GetMapping
    fun list(): List<ViewCharacter> {
        return viewCharacterService.list()
    }
}
