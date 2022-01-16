package com.ivangrod.needlehackpost.infrastructure.post.messaging.config

import com.ivangrod.needlehackpost.infrastructure.post.messaging.Receiver
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
open class MessagingRabbitmqConfiguration {

    val queueName = "needlehack-post"

    @Bean
    fun receiver(): Receiver? {
        return Receiver()
    }

    @Bean
    fun listenerAdapter(receiver: Receiver?): MessageListenerAdapter? {
        return MessageListenerAdapter(receiver, "receiveMessage")
    }

    @Bean
    fun container(
        connectionFactory: ConnectionFactory?,
        listenerAdapter: MessageListenerAdapter
    ): SimpleMessageListenerContainer? {
        val container = SimpleMessageListenerContainer()
        connectionFactory?.let {
            container.connectionFactory = it
        }
        container.setQueueNames(queueName)
        container.setMessageListener(listenerAdapter)
        return container
    }
}

