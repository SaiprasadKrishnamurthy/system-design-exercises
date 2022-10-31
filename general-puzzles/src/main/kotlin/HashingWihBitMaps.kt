
import org.roaringbitmap.RoaringBitmap


object HashingWihBitMaps {

    @JvmStatic
    fun main(args: Array<String>) {
        val noOfServers = 10
        val servers = (1..noOfServers).map { "Server $it" }.toList()
        println(servers)
        val rr2 = RoaringBitmap()
        (1..10).forEach { key ->
            /*
             *  K1: [s1, s2, s3]
             *  K2: [s2, s3, s1]
             *  K1: [s4, s1, s2, s3]
             */
        }



    }
}