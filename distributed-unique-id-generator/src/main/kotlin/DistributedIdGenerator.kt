class DistributedIdGenerator(
    private val epochService: EpochService,
    private val counterService: CounterService
) {

    fun getId(datacenterId: Int, machineId: Int): Long {
        val bit1 = 0
        val epoch = epochService.millisSinceEpoch()
        val sequence = counterService.getSequence(datacenterId, machineId, epoch)
        val id =
            bit1.toString() + epoch.toString() + datacenterId.toString() + machineId.toString() + sequence.toString()
        return id.toLong()
    }
}