object NumericUtils {

    private const val DIGITS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"

    fun toBase62(number: String): String {
        var rem: Long
        var quo: Long = Long.MAX_VALUE
        var n = number.toLong()
        val remainders = mutableListOf<Int>()
        while (quo > 0) {
            quo = n / 62
            rem = n % 62
            remainders.add(rem.toInt())
            n = quo
        }
        return remainders.joinToString("") { DIGITS[it].toString() }
    }
}