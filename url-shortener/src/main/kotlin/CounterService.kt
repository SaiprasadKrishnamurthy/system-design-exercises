import java.util.concurrent.ConcurrentHashMap

class CounterService {
    // In reality this will be An expiry map that expires the entries every 2 seconds to avoid memory leaks.
    private val COUNTERS = ConcurrentHashMap<Long, Int>()

    fun getSequence(epoch: Long): Int {
        return COUNTERS.compute(epoch) { _, v ->
            if (v == null) {
                1
            } else {
                v + 1
            }
        }!!
    }
}