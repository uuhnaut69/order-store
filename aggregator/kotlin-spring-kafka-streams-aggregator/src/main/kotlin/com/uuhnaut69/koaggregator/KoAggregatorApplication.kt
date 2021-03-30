package com.uuhnaut69.koaggregator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafkaStreams

@EnableKafkaStreams
@SpringBootApplication
class KoAggregatorApplication

fun main(args: Array<String>) {
    runApplication<KoAggregatorApplication>(*args)
}
