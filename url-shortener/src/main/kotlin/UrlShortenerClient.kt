import java.util.*

object UrlShortenerClient {
    @JvmStatic
    fun main(args: Array<String>) {
        val service = UrlShortenerService(EpochService(), CounterService())
        (1 until 100).forEach { i ->
            val shortened = service.getShortUrl(
                UrlShortenRequest(
                    "sai",
                    "https://taxreco.in/tax-reco/#/tds-job?jobId=$${UUID.randomUUID()}",
                    1
                )
            )
            println(shortened)
        }
    }
}