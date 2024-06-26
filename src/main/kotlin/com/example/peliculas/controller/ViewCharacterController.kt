package com.example.peliculas.controller

import com.example.peliculas.entity.ViewCharacter
import com.example.peliculas.service.ViewCharacterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/view-characters")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class ViewCharacterController {

    @Autowired
    lateinit var viewCharacterService: ViewCharacterService

    @GetMapping
    fun list(): List<ViewCharacter> {
        return viewCharacterService.list()
    }
}
