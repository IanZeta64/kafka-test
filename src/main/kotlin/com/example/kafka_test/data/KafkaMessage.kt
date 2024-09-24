package com.example.kafka_test.data

import java.io.Serializable


data class KafkaMessage(val topic: String, val body: String): Serializable


