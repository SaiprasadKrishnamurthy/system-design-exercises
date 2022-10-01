package session

import message.Message

class MessageDeliveryService {
    fun deliver(message: Message) {
        println("${message.from} says ${message.text} to ${message.to}")
    }
}
