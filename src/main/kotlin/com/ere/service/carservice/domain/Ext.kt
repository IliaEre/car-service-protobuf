package com.ere.service.carservice.domain

import main.java.protobuf.ProtoCar

fun Car.toProto(): ProtoCar = ProtoCar.newBuilder()
        .setId(this.id)
        .setName(this.name)
        .setTitle(this.description)
        .build()
