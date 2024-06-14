package com.example.peliculas.controller

import com.example.peliculas.entity.Scene
import com.example.peliculas.service.SceneService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/scenes")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class SceneController {

    @Autowired
    lateinit var sceneService: SceneService

    @GetMapping
    fun list(): List<Scene> {
        return sceneService.list()
    }

    @PostMapping
    fun save(@RequestBody scene: Scene): Scene {
        return sceneService.save(scene)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody scene: Scene): Scene {
        return sceneService.update(id, scene)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        sceneService.delete(id)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Scene {
        return sceneService.getById(id)
    }

    @PatchMapping("/{id}")
    fun partialUpdate(@PathVariable id: Long, @RequestBody partialScene: Map<String, Any>): Scene {
        return sceneService.partialUpdate(id, partialScene)
    }
}
