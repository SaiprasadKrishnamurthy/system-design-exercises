class UrlShortenerService(
    private val epochService: EpochService,
    private val counterService: CounterService
) {

    private val PREFIX = "https://sho.rt/%s"

    private val random = java.util.Random()
    fun getShortUrl(urlShortenRequest: UrlShortenRequest): String {
        val serverId = urlShortenRequest.serverId
        val millisSinceEpoch = epochService.millisSinceEpoch()
        val sequence = counterService.getSequence(millisSinceEpoch)
        val rawId = serverId.toString() + millisSinceEpoch.toString() + sequence.toString() + random.nextInt(10000)
        val encoded = NumericUtils.toBase62(rawId)
        return String.format(PREFIX, encoded)
    }
}