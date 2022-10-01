package message

import java.util.*

data class Message(
    val id: String = UUID.randomUUID().toString(),
    val from: String,
    val to: String,
    val text: String,
    val timestamp: Long = System.nanoTime()
)
