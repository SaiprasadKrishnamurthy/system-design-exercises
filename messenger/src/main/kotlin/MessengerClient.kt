import common.MockMessageBroker
import message.Message
import session.MessageDeliveryService
import session.SessionRepository
import session.SessionService
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

object MessengerClient {
    @JvmStatic
    fun main(args: Array<String>) {
        val countDownLatch = CountDownLatch(3)
        val messageBroker = MockMessageBroker()
        val sessionService =
            SessionService(SessionRepository(), messageBroker, MessageDeliveryService(), countDownLatch)
        val messageDeliveryService = MessageDeliveryService()

        val from = "Sai"
        val to = "Kris"
        sessionService.connect(from)
        sessionService.connect(to)
        messageDeliveryService.deliver(Message(from = from, to = to, text = "Hey, Howdy?"))
        messageDeliveryService.deliver(Message(from = to, to = from, text = "Hey, I'm good. What's cooking?"))
        messageDeliveryService.deliver(Message(from = from, to = to, text = "Just regular stuff!"))
        countDownLatch.await(3, TimeUnit.SECONDS)
        sessionService.shutdown()
    }
}