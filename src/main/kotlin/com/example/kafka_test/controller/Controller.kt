package com.example.kafka_test.controller

import com.example.kafka_test.data.KafkaMessage
import com.example.kafka_test.producer.Producer
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kafka")
class Controller
    (
    private val producer: Producer,
    @Value("\${kafka.topics:}")
    private val topic: String
) {


    @PostMapping
    fun sendKafkaMessage(@RequestParam message: String) {
        producer.send(KafkaMessage(topic, message))
    }
}