package com.ere.service.carservice.service

import com.ere.service.carservice.domain.Car
import com.ere.service.carservice.repository.CarRepository
import main.java.protobuf.ProtoCar
import org.springframework.stereotype.Service

interface CarService {
    fun getCar(id: Long): ProtoCar?
    fun getAll()
    fun save()
}

@Service
internal class CarServiceImpl(
    private val carRepository: CarRepository
): CarService {

    override fun getCar(id: Long): ProtoCar? {
        val c = Car(1L, " ", " ") // todo: soma logic here

        return ProtoCar.newBuilder()
            .setId(1)
            .setName("")
            .setTitle("")
            .build()
    }

    override fun getAll() {

        TODO("Not yet implemented")
    }

    override fun save() {
        TODO("Not yet implemented")
    }

}