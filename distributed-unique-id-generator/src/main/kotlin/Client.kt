object Client {
    @JvmStatic
    fun main(args: Array<String>) {

        val service = DistributedIdGenerator(EpochService(), CounterService())
        for (i in 1..100) {
            println(service.getId(1, 1))
        }
    }
}