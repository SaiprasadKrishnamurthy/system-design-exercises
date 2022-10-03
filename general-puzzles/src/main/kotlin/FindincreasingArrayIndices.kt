object FindincreasingArrayIndices {

    /*
        Problem: For a given array arr, find 3 indices i,j,k such that:
        i<j<k and arr[i] < arr[j] < arr[k]
        Eg: arr = [1,3,2,4]
        expected output: [0,2,3]
     */
    @JvmStatic
    fun main(args: Array<String>) {
        val arr = arrayOf(1, 3, 2, 4)

        var currIdx = 0
        var nextIdx = 1
        var nextToNextIdx = 2
        val results = mutableListOf<Int>()
        while (true) {
            if (listOf(currIdx, nextIdx, nextToNextIdx).any { it >= arr.size }) {
                results.addAll(listOf(-1, -1, -1))
                break
            }
            if (arr[nextIdx] in (arr[currIdx] + 1) until arr[nextToNextIdx]) {
                results.add(currIdx)
                results.add(nextIdx)
                results.add(nextToNextIdx)
                break
            }
            if (arr[nextIdx] <= arr[currIdx]) {
                currIdx = nextIdx
                nextIdx += 1
            }
            if (arr[nextToNextIdx] <= arr[nextIdx]) {
                nextIdx = nextToNextIdx
                nextToNextIdx += 1
            }
        }
        println(" Result: $results")
    }
}