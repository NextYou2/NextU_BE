package com.nextyou.be.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "example")
class Chat(sender: String, receiver: String, message: String) {
    @Id
    var id: String? = null
    private var message: String = "msg"
    private var sender: String = "sender"
    private var receiver: String = "receiver"
    var createdAt: LocalDateTime = LocalDateTime.now()

    init {
        this.message = message
        this.sender = sender
        this.receiver = receiver
    }
}
