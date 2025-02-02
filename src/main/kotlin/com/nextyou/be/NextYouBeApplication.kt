package com.nextyou.be

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@SpringBootApplication
@EnableReactiveMongoRepositories
class NextYouBeApplication

fun main(args: Array<String>) {
    runApplication<NextYouBeApplication>(*args)
}
