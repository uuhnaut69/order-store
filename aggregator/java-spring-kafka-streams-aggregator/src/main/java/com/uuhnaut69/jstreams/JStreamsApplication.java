package com.uuhnaut69.jstreams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@EnableKafkaStreams
@SpringBootApplication
public class JStreamsApplication {

  public static void main(String[] args) {
    SpringApplication.run(JStreamsApplication.class, args);
  }
}
