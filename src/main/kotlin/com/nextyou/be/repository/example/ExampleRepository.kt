package com.nextyou.be.repository.example

import com.nextyou.be.entity.Chat
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.data.mongodb.repository.Tailable
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface ExampleRepository : ReactiveMongoRepository<Chat, String> {
    @Tailable
    fun findBySenderAndReceiver(sender: String, receiver: String): Flux<Chat>
}