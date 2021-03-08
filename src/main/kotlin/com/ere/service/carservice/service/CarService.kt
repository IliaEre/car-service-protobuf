package com.ere.service.carservice.service

import com.ere.service.carservice.domain.exception.CarNotFoundException
import com.ere.service.carservice.domain.toProto
import com.ere.service.carservice.repository.CarRepository
import main.java.protobuf.ProtoCar
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface CarService {
    suspend fun getCar(id: Long): Mono<ProtoCar>
    suspend fun getAll(): Flux<ProtoCar>
}

@Service
internal class CarServiceImpl(
    private val carRepository: CarRepository
): CarService {

    override suspend fun getCar(id: Long): Mono<ProtoCar> =
        carRepository.findById(id)
            .map { it.toProto() }
            .switchIfEmpty(Mono.error { throw CarNotFoundException("Car with id:$id was not found.") })

    override suspend fun getAll(): Flux<ProtoCar> =
        carRepository.findAll()
            .map { it.toProto() }
}