import kotlin.math.abs

object FindElementsWhoseSumIsN {
    @JvmStatic
    fun main(args: Array<String>) {
        val n = 21
        val arr = arrayOf(2, 4, 7, 19, 21)
        val tolerance = 1.0

        println(findElements(arr, n, tolerance))
    }

    private fun findElements(arr: Array<Int>, n: Int, tolerance: Double = 0.0): List<Int> {
        val gathered = mutableListOf<Int>()
        parts(n, arr, gathered, 0, n, tolerance)
        return gathered
    }

    private fun parts(
        n: Int,
        arr: Array<Int>,
        gathered: MutableList<Int>,
        acc: Int,
        target: Int = n,
        tolerance: Double
    ) {
        if (n <= 0) {
            if (acc != target && abs(acc - target) > tolerance) {
                gathered.clear()
            }
            return
        }
        val closest = when (val i = arr.indexOfFirst { it >= n }) {
            0 -> arr[0]
            arr.size - 1 -> arr[arr.size - 1]
            -1 -> arr[arr.size - 1]
            else -> arr[i - 1]
        }

        gathered.add(closest)
        parts(n - closest, arr, gathered, acc + closest, target, tolerance)
    }
}