package com.example.peliculas.controller

import com.example.peliculas.entity.ViewScene
import com.example.peliculas.service.ViewSceneService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/viewScene")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class ViewSceneController {

    @Autowired
    lateinit var viewSceneService: ViewSceneService

    @GetMapping
    fun list(): List<ViewScene> {
        return viewSceneService.list()
    }
}
