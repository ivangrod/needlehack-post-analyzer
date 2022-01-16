package com.ivangrod.needlehackpost.infrastructure.post.messaging

import com.ivangrod.needlehackpost.infrastructure.post.messaging.dto.PostMessage
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.util.concurrent.CountDownLatch


class Receiver {

    private val latch = CountDownLatch(1)

    fun receiveMessage(message: String) {

        val post = Json.decodeFromString<PostMessage>(message)

        println("Received <$post>")
        latch.countDown()
    }
}
