# Stream Playground

Stream playground example

## Prerequisites

- Java 11 +
- Docker
- Docker-compose

## Examples

| Application Name | Concepts used| Java Spring Kafka Streams | Java Spring Cloud Streams | Kotlin Spring Kafka Streams | Kotlin Spring Cloud Streams |
| --- | --- |--- | --- |--- | --- |
| Stream Processing Application | `fk-join` between `KTable` and `KTable`, aggregation, stateful  | [Example](https://github.com/uuhnaut69/stream-playground/tree/main/aggregator/java-spring-kafka-streams-aggregator)|[Example](https://github.com/uuhnaut69/stream-playground/tree/main/aggregator/java-spring-cloud-streams-aggregator)|[Example](https://github.com/uuhnaut69/stream-playground/tree/main/aggregator/kotlin-spring-kafka-streams-aggregator)| [Example](https://github.com/uuhnaut69/stream-playground/tree/main/aggregator/kotlin-spring-cloud-streams-aggregator)|

## Get Started

### 1. Start env

```shell
docker-compose up -d
```

### 2. Build projects

```shell
sh build-all.sh
```

### 3. Start api project

- Start api project to create some data (2 option version: Java-Javer, Kotlin-Kover)

### 4. Create connectors

```shell
sh create-connectors.sh
```

### 5. Choose demo via link above to start