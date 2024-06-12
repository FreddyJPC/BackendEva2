package com.example.peliculas.service

import com.example.peliculas.entity.ViewScene
import com.example.peliculas.repository.ViewSceneRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ViewSceneService {

    @Autowired
    lateinit var viewSceneRepository: ViewSceneRepository

    fun list(): List<ViewScene> {
        return viewSceneRepository.findAll()
    }
}
