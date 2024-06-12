package com.example.peliculas.service

import com.example.peliculas.entity.Film
import com.example.peliculas.repository.FilmRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FilmService {

    @Autowired
    lateinit var filmRepository: FilmRepository

    fun list(): List<Film> {
        return filmRepository.findAll()
    }

    fun save(film: Film): Film {
        return filmRepository.save(film)
    }

    fun update(id: Long, film: Film): Film {
        val existingFilm = filmRepository.findById(id)
            .orElseThrow { EntityNotFoundException("No se encontró la película con el ID: $id") }

        existingFilm.title = film.title
        existingFilm.director = film.director
        existingFilm.duration = film.duration

        return filmRepository.save(existingFilm)
    }

    fun delete(id: Long) {
        val existingFilm = filmRepository.findById(id)
            .orElseThrow { EntityNotFoundException("No se encontró la película con el ID: $id") }

        filmRepository.delete(existingFilm)
    }

    fun getById(id: Long): Film {
        return filmRepository.findById(id)
            .orElseThrow { EntityNotFoundException("No se encontró la película con el ID: $id") }
    }

    fun partialUpdate(id: Long, partialFilm: Map<String, Any>): Film {
        val existingFilm = filmRepository.findById(id)
            .orElseThrow { EntityNotFoundException("No se encontró la película con el ID: $id") }

        partialFilm.forEach { (key, value) ->
            when (key) {
                "title" -> existingFilm.title = value as String
                "director" -> existingFilm.director = value as String
                "duration" -> existingFilm.duration = value as Int
                else -> throw IllegalArgumentException("Campo no válido para actualización parcial: $key")
            }
        }

        return filmRepository.save(existingFilm)
    }
}
