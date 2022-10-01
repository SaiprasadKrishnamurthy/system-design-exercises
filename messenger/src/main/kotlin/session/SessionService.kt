package session

import common.MockMessageBroker
import java.util.*
import java.util.concurrent.CountDownLatch

class SessionService(
    private val sessionRepository: SessionRepository,
    private val messageBroker: MockMessageBroker,
    private val messageDeliveryService: MessageDeliveryService,
    private val countDownLatch: CountDownLatch,
    private val timer: Timer = Timer() // for testing.
) {
    init {
        timer.schedule(object : TimerTask() {
            override fun run() {
                val message = messageBroker.getMessageToDeliver()
                message?.let {
                    sessionRepository.getSession(message.to)?.let {
                        messageDeliveryService.deliver(message)
                        countDownLatch.countDown() // for testing.
                        // Handling retries etc. (Out of scope)
                    }
                }
            }
        }, 1000)
    }

    fun connect(userId: String) {
        sessionRepository.connect(Session(userId))
    }

    fun shutdown() {
        timer.cancel()
    }
}