package com.example.peliculas.controller

import com.example.peliculas.entity.Film
import com.example.peliculas.service.FilmService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/films")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class FilmController {

    @Autowired
    lateinit var filmService: FilmService

    @GetMapping
    fun list(): List<Film> {
        return filmService.list()
    }

    @PostMapping
    fun save(@RequestBody film: Film): Film {
        return filmService.save(film)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody film: Film): Film {
        return filmService.update(id, film)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        filmService.delete(id)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Film {
        return filmService.getById(id)
    }

    @PatchMapping("/{id}")
    fun partialUpdate(@PathVariable id: Long, @RequestBody partialFilm: Map<String, Any>): Film {
        return filmService.partialUpdate(id, partialFilm)
    }
}
