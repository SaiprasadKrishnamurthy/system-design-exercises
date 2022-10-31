object LongestIncreasingSequence {

    /*
        Given an N * M matrix, containing distinct numbers, find the length of the longest increasing path in that matrix such that
        the numbers in the cells along the path are in increasing order with a difference of 1.
        Note: You’re allowed to move in 4 directions, left, right, top, and down. From a cell (i,j),
        you can move to cell (i+1,j), (i,j+1), (i-1,j), and (i,j-1).
     */
    data class Indices(val i: Int, val j: Int, val match: Boolean = false)

    @JvmStatic
    fun main(args: Array<String>) {


        val matrix = arrayOf(
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(6, 7, 8, 9, 10),
            intArrayOf(11, 12, 13, 14, 15),
            intArrayOf(16, 17, 18, 19, 20)
        )
    }
}