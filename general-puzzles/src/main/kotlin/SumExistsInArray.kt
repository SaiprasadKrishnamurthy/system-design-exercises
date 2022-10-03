object SumExistsInArray {

    /*
        Problem: For a given array arr, find if a sum of it's exists
        Eg: arr = [1,3,2,4], sum = 5
        expected output: true because 1 + 4 = 5
     */
    @JvmStatic
    fun main(args: Array<String>) {
        val arr = arrayOf(1, 1, 1, 2, 4, 17, 8)
        val total = 30
        val l = arr.sortedDescending() // O(n log n)
        var found = false
        var remainder = total
        // O(n)
        for (i in l.indices) {
            if (remainder - l[i] >= 0) {
                remainder -= l[i]
                if (remainder == 0) {
                    found = true
                    break
                }
            }
        }
        println("Sum exists: $found")
    }
}