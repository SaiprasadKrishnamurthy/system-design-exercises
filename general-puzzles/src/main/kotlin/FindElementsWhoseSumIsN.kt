object FindElementsWhoseSumIsN {
    @JvmStatic
    fun main(args: Array<String>) {
        val n = 23
        val arr = arrayOf(2, 4, 7, 19, 21)
        println(findElements(arr, n))
    }

    fun findElements(arr: Array<Int>, n: Int): List<Int> {
        val gathered = mutableListOf<Int>()
        parts(n, arr, gathered, 0)
        return gathered
    }

    private fun parts(n: Int, arr: Array<Int>, gathered: MutableList<Int>, acc: Int, target: Int = n) {
        if (n <= 0) {
            if (acc != target) {
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
        parts(n - closest, arr, gathered, acc + closest, target)
    }
}