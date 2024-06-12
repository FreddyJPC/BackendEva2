package com.example.peliculas.service

import com.example.peliculas.entity.ViewCharacter
import com.example.peliculas.repository.ViewCharacterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ViewCharacterService {

    @Autowired
    lateinit var viewCharacterRepository: ViewCharacterRepository

    fun list(): List<ViewCharacter> {
        return viewCharacterRepository.findAll()
    }
}
