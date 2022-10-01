package message

import common.MockMessageBroker

class MessageService(
    private val messageRepository: MessageRepository,
    private val messagePublisher: MessagePublisher,
    private val mediaRepository: MediaRepository,
    private val messageBroker: MockMessageBroker
) {
    fun sendMessage(message: Message) {
        messagePublisher.publish(message)
        messageRepository.save(message)
        mediaRepository.save(message)
    }
}