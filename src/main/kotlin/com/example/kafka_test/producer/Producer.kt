package com.example.kafka_test.producer

import com.example.kafka_test.data.KafkaMessage
import io.github.oshai.kotlinlogging.KLogger
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class Producer
    (
    private val kafkaTemplate: KafkaTemplate<String, KafkaMessage>,
    private val logger: KLogger = KotlinLogging.logger {},
    @Value("\${kafka.topics:}")
    private val topic: String
) {
    fun send(message: KafkaMessage) {
        logger.info { "enviando mensagem para topico ${topic}..." }
        kafkaTemplate.send(message.topic, message)
        logger.info { "mensagem enviada para topico ${topic}!" }
    }
}