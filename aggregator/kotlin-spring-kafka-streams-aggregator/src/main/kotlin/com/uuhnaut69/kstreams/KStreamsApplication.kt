package com.uuhnaut69.kstreams

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafkaStreams

@EnableKafkaStreams
@SpringBootApplication
class KStreamsApplication

fun main(args: Array<String>) {
    runApplication<KStreamsApplication>(*args)
}
