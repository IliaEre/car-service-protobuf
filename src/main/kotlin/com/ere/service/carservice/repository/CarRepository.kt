package com.ere.service.carservice.repository

import com.ere.service.carservice.domain.Car
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface CarRepository: ReactiveCrudRepository<Car, String> {

}

