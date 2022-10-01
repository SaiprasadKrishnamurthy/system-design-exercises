package common

import message.Message
import java.util.concurrent.ConcurrentLinkedQueue

/**
 * A simple class to emulate kafka broker (or any message broker)
 */
class MockMessageBroker {
    private val MESSAGE_TO_DELIVER_TOPIC = ConcurrentLinkedQueue<Message>()
    private val DELIVERY_RETRY_TOPIC = ConcurrentLinkedQueue<Message>()

    fun publishToMessageToDeliverTopic(message: Message) {
        MESSAGE_TO_DELIVER_TOPIC.add(message)
    }

    fun getMessageToDeliver(): Message? {
        return MESSAGE_TO_DELIVER_TOPIC.poll()
    }
}