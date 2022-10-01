import java.util.concurrent.ConcurrentHashMap

class CounterService {
    // In reality this will be maintaining the count in a distributed in memory store like Redis/Hazelcast.
    private val COUNTERS = ConcurrentHashMap<String, Int>()

    fun getSequence(datacenterId: Int, machineId: Int, epoch: Long): Int {
        val key = datacenterId.toString() + "_" + machineId + "_" + epoch
        return COUNTERS.compute(key) { _, v ->
            if (v == null) {
                1
            } else {
                v + 1
            }
        }!!
    }
}