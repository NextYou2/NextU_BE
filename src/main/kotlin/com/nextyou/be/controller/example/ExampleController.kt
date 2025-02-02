package com.nextyou.be.controller.example

import com.nextyou.be.entity.Chat
import com.nextyou.be.service.example.ExampleService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/example")
@Tag(name = "예제", description = "예제 API")
class ExampleController(
    private val exampleService: ExampleService,
) {
    @GetMapping("/sender/{sender}/receiver/{receiver}", produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    suspend fun getMessage(
        @PathVariable sender: String,
        @PathVariable receiver: String,
    ): Flux<Chat> {
        return exampleService.getMessage(sender, receiver)
    }

    @PostMapping("/chat")
    suspend fun sendMessage(@RequestBody chat: Chat): Mono<Chat> {
        return exampleService.save(chat)
    }
}