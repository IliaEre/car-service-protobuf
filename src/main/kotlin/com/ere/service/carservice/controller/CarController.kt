package com.ere.service.carservice.controller

import com.ere.service.carservice.controller.CarController.Companion.PROTOBUF_MEDIA_TYPE_VALUE
import com.ere.service.carservice.service.CarService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@RestController
@RequestMapping(value = ["v1/cars"], consumes = [PROTOBUF_MEDIA_TYPE_VALUE], produces = [PROTOBUF_MEDIA_TYPE_VALUE])
class CarController(
    private val carService: CarService
) {

    @GetMapping("/{id}")
    fun getCar(@PathVariable id: Long) =
        carService.getCar(id)
            ?.let { ResponseEntity.ok(it) }
            ?: kotlin.run { ResponseEntity.notFound() }

    @GetMapping
    fun getCars() = carService.getAll()

    @PostMapping
    fun create() {
    }

    companion object {
        const val PROTOBUF_MEDIA_TYPE_VALUE = "application/x-protobuf"
    }
}
