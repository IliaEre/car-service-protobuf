package com.ere.service.carservice.repository

import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface CarRepository: ReactiveCrudRepository<String, String> {

}

