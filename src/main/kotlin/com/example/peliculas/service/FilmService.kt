package com.example.peliculas.service

import com.example.peliculas.entity.Film
import com.example.peliculas.repository.FilmRepository
import com.example.peliculas.repository.SceneRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
@Service
class FilmService {

    @Autowired
    lateinit var filmRepository: FilmRepository

    @Autowired
    lateinit var sceneRepository: SceneRepository

    fun list(): List<Film> {
        return filmRepository.findAll()
    }

    fun save(film: Film): Film {
        return filmRepository.save(film)
    }

    fun update(id: Long, film: Film): Film {
        val existingFilm = filmRepository.findById(id).orElseThrow { RuntimeException("Film not found") }
        existingFilm.title = film.title
        existingFilm.director = film.director
        existingFilm.duration = film.duration
        return filmRepository.save(existingFilm)
    }

    fun delete(id: Long) {
        if (sceneRepository.existsByFilmId(id)) {
            sceneRepository.deleteByFilmId(id)
        }
        filmRepository.deleteById(id)
    }

    fun getById(id: Long): Film {
        return filmRepository.findById(id).orElseThrow { RuntimeException("Film not found") }
    }

    fun partialUpdate(id: Long, partialFilm: Map<String, Any>): Film {
        val film = filmRepository.findById(id).orElseThrow { RuntimeException("Film not found") }
        partialFilm.forEach { (key, value) ->
            when (key) {
                "title" -> film.title = value as String
                "director" -> film.director = value as String
                "duration" -> film.duration = value as Int
            }
        }
        return filmRepository.save(film)
    }
}
