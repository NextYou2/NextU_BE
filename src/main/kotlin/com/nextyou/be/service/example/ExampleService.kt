package com.nextyou.be.service.example

import com.nextyou.be.entity.Chat
import com.nextyou.be.repository.example.ExampleRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers

@Service
class ExampleService(
    private val exampleRepository: ExampleRepository,
) {
    suspend fun getMessage(sender: String, receiver: String): Flux<Chat> {
        println("getMessage")
        return exampleRepository.findBySenderAndReceiver(sender, receiver)
            .subscribeOn(Schedulers.boundedElastic())
    }

    suspend fun save(chat: Chat): Mono<Chat> {
        println("save")
        return exampleRepository.save(chat)
    }
}