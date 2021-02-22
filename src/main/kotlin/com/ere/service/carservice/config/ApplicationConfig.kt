package com.ere.service.carservice.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter

/**
 * Read more:
 * <a href="https://developers.google.com/protocol-buffers/">Google Protocol Buffers</a>.
 */
@Configuration
class ApplicationConfig {

    @Bean
    fun protobufHttpMessageConverter(): ProtobufHttpMessageConverter {
        return ProtobufHttpMessageConverter()
    }
}
