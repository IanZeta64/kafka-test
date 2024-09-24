package com.example.kafka_test.consumer

import com.example.kafka_test.data.KafkaMessage
import io.github.oshai.kotlinlogging.KotlinLogging
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.stereotype.Component

@Component
class Consumer {
    private val logger = KotlinLogging.logger {}

    @KafkaListener(topics = ["\${kafka.topics}"], groupId = "group_id")
    fun listener(message: ConsumerRecord<String, KafkaMessage>,
                 ack: Acknowledgment) {
        logger.info { "mensagem recebida: ${message}" }
        ack.acknowledge()
        logger.info { "acknowledge enviado!" }
    }
}