object MaxSubArraySum {
    @JvmStatic
    fun main(args: Array<String>) {

        data class Holder(var sum: Int, val idxes: MutableList<Int>) {
            fun reset() {
                sum = 0
                idxes.clear()
            }
        }

        val arr = arrayOf(-4, 5, 7, -6, 10, -15, 3)

        /**
         * BS = min
         * 0 = 1 {0}, bs = 1
         * 1 = 6 {0,1}, bs = 6
         * 2 = -2 push {0,1},
         * 3 = 1 {3}
         * 4 = 2 {3,4} push {3, 4} with 4
         */

        var max_so_far = Int.MIN_VALUE
        var max_ending_here = 0
        var min_start_here = 0

        arr.forEachIndexed { i, n ->
            max_ending_here += n
            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here
                println(i)
            }
            if (max_ending_here < 0) {
                max_ending_here = 0
            }
        }
        println(max_so_far)

    }
}