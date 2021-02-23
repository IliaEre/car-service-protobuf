package com.ere.service.carservice.controller

import com.ere.service.carservice.domain.exception.CarNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class CarControllerAdvice {

    @ExceptionHandler(CarNotFoundException::class)
    fun notFoundHandle(ex: CarNotFoundException) = ResponseEntity.notFound()

}
