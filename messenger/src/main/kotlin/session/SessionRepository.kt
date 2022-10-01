package session

import java.util.concurrent.ConcurrentHashMap

class SessionRepository {
    private val SESSIONS = ConcurrentHashMap<String, Session>()

    fun connect(session: Session) {
        SESSIONS.putIfAbsent(session.userId, session)
    }

    fun getSession(userId: String): Session? {
        return SESSIONS.getOrDefault(userId, null)
    }
}
