object SumofN {
    @JvmStatic
    fun main(args: Array<String>) {

        val n = 5
        println(sum(0, n))

    }

    fun sum(c: Int, n: Int): Int {
        return if (c == n) c
        else c + sum(c + 1, n)
    }
}