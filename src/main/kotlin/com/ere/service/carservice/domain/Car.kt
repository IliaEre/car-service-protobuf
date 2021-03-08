package com.ere.service.carservice.domain

import org.springframework.data.annotation.Id

data class Car(
    @field:Id
    val id: Int,
    val name: String,
    val description: String
)
