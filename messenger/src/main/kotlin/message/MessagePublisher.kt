package message

import common.MockMessageBroker

class MessagePublisher(private val messageBroker: MockMessageBroker) {
    fun publish(message: Message) {
        messageBroker.publishToMessageToDeliverTopic(message)
    }
}
