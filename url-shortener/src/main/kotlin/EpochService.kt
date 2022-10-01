import java.time.LocalDateTime
import java.time.Month
import java.time.temporal.ChronoUnit

class EpochService {

    private val EPOCH = LocalDateTime.of(
        2020,
        Month.JANUARY, 1, 0, 0, 0
    )

    fun millisSinceEpoch() =
        ChronoUnit.MILLIS.between(EPOCH, LocalDateTime.now())
}