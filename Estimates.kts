#!/usr/bin/env kotlin

fun withSuffixCounts(count: Long): String? {
    if (count < 1000) return "" + count
    val exp = (Math.log(count.toDouble()) / Math.log(1000.0)).toInt()
    return String.format(
        "%.1f %c",
        count / Math.pow(1000.0, exp.toDouble()),
        "KMBTQ"[exp - 1]
    )
}

fun withSuffixStorage(count: Long): String? {
    if (count < 1000) return "" + count
    val exp = (Math.log(count.toDouble()) / Math.log(1000.0)).toInt()
    return String.format(
        "%.1f %c",
        count / Math.pow(1000.0, exp.toDouble()),
        "kMGTP"[exp - 1]
    )
}

fun prompt() {
    println("Choose the following option")
    println("\t 1. No of users/operations calculation")
    println("\t 2. Storage calculation")
    println("\t 3. Exit")
    val option = readLine()!!.trim()
    if (option == "1".trim()) {
        reqsCalculation()
    } else if (option == "2".trim()) {
        storageCalculation()
    } else if (option == "3".trim()) {
        System.exit(0)
    }
}

fun reqsCalculation() {
    try {
        println()
        println("No of Requests/Users (eg: 1K, 1M, 1B, 1T): ")
        val n = readLine()!!.trim()

        println("Time unit (eg: D,M,Y): ")
        val t = readLine()!!.trim()

        val numericDenomination = when (n.last()) {
            'K' -> ("Thousand" to 1000)
            'M' -> ("Million" to 1000000)
            'B' -> ("Billion" to 1000000000)
            'T' -> ("Trillion" to 1000000000000)
            else -> ("Unknown" to "Unknown")
        }
        val numeric = n.take(n.length - 1).trim().toInt()

        val timeUnit = when (t.toCharArray()[0]) {
            'D' -> "Day"
            'M' -> "Month"
            'Y' -> "Year"
            else -> "Unknown input"
        }
        println("${numeric} (${withSuffixCounts(numeric.toLong())}) users/requests per ${timeUnit}")

        when (timeUnit) {
            "Year" -> {
                val l = listOf(
                    "Per Month: " to Math.round(
                        ((numeric.toString().toDouble() * numericDenomination.second.toString()
                            .toDouble()).toDouble()) / (12.0)
                    ),
                    "Per Week: " to Math.round(
                        ((numeric * numericDenomination.second.toString().toDouble()).toDouble()) / (52.0)
                    ),
                    "Per Day" to Math.round(
                        ((numeric * numericDenomination.second.toString().toDouble()).toDouble()) / (12.0 * 30.0)
                    ),
                    "Per Hour" to Math.round(
                        ((numeric * numericDenomination.second.toString().toDouble()).toDouble()) / (12.0 * 30.0 * 24.0)
                    ),
                    "Per Minute" to
                            Math.round(
                                ((numeric * numericDenomination.second.toString()
                                    .toDouble()).toDouble()) / (12.0 * 30.0 * 24.0 * 60.0)
                            ),
                    "Per Second" to
                            Math.round(
                                ((numeric * numericDenomination.second.toString()
                                    .toDouble()).toDouble()) / (12.0 * 30.0 * 24.0 * 60.0 * 60.0)
                            )
                )
                l.forEach { println("$numeric Users/Requests per ${it.first} (${withSuffixCounts(it.second.toLong())}):  ${it.second}") }
                println("\n\n-------------------------------------------------\n\n")
            }
            "Month" -> {
                val l = listOf(
                    "Per Year: " to Math.round(
                        ((numeric.toString().toDouble() * numericDenomination.second.toString()
                            .toDouble()).toDouble()) * (12.0)
                    ),
                    "Per Week: " to Math.round(
                        ((numeric * numericDenomination.second.toString().toDouble()).toDouble()) / (4.0)
                    ),
                    "Per Day" to Math.round(
                        ((numeric * numericDenomination.second.toString().toDouble()).toDouble()) / (30.0)
                    ),
                    "Per Hour" to Math.round(
                        ((numeric * numericDenomination.second.toString().toDouble()).toDouble()) / (30.0 * 24.0)
                    ),
                    "Per Minute" to
                            Math.round(
                                ((numeric * numericDenomination.second.toString()
                                    .toDouble()).toDouble()) / (30.0 * 24.0 * 60.0)
                            ),
                    "Per Second" to
                            Math.round(
                                ((numeric * numericDenomination.second.toString()
                                    .toDouble()).toDouble()) / (30.0 * 24.0 * 60.0 * 60.0)
                            )
                )
                l.forEach { println("$numeric Users/Requests per ${it.first} (${withSuffixCounts(it.second.toLong())}):  ${it.second}") }
                println("\n\n-------------------------------------------------\n\n")
            }
            "Day" -> {
                val l = listOf(
                    "Per Year: " to Math.round(
                        ((numeric.toString().toDouble() * numericDenomination.second.toString()
                            .toDouble()).toDouble()) * (365.0)
                    ),
                    "Per Week: " to Math.round(
                        ((numeric * numericDenomination.second.toString().toDouble()).toDouble()) * (7.0)
                    ),
                    "Per Day" to Math.round(
                        ((numeric * numericDenomination.second.toString().toDouble()).toDouble())
                    ),
                    "Per Hour" to Math.round(
                        ((numeric * numericDenomination.second.toString().toDouble()).toDouble()) / (24.0)
                    ),
                    "Per Minute" to
                            Math.round(
                                ((numeric * numericDenomination.second.toString()
                                    .toDouble()).toDouble()) / (24.0 * 60.0)
                            ),
                    "Per Second" to
                            Math.round(
                                ((numeric * numericDenomination.second.toString()
                                    .toDouble()).toDouble()) / (24.0 * 60.0 * 60.0)
                            )
                )
                l.forEach { println("$numeric Users/Requests per ${it.first} (${withSuffixCounts(it.second.toLong())}):  ${it.second}") }
                println("\n\n-------------------------------------------------\n\n")
            }
        }

    } catch (e: Exception) {
        e.printStackTrace()
        System.err.println("Invalid input!")
    }
}


fun storageCalculation() {
    try {
        println()
        println("No of Bytes (eg: 1K, 1M, 1B, 1T): ")
        val n = readLine()!!.trim()

        println("Time unit (eg: s,m (Seconds and Minutes)): ")
        val t = readLine()!!.trim()

        val numericDenomination = when (n.last()) {
            'K' -> ("Thousand" to 1000)
            'M' -> ("Million" to 1000000)
            'B' -> ("Billion" to 1000000000)
            'T' -> ("Trillion" to 1000000000000)
            else -> ("Unknown" to "Unknown")
        }
        val numeric = n.take(n.length - 1).trim().toInt()

        val timeUnit = when (t.toCharArray()[0]) {
            's' -> "Second"
            'm' -> "Minute"
            else -> "Unknown input"
        }
        println("${numeric} (${withSuffixCounts(numeric.toLong())}) bytes per ${timeUnit}")

        when (timeUnit) {
            "Second" -> {
                val l = listOf(
                    "Per Month: " to Math.round(
                        ((numeric.toString().toDouble() * numericDenomination.second.toString()
                            .toDouble()).toDouble()) * (60.0 * 60.0 * 24.0 * 30.0)
                    ),
                    "Per Year: " to Math.round(
                        ((numeric.toString().toDouble() * numericDenomination.second.toString()
                            .toDouble()).toDouble()) * (60.0 * 60.0 * 24.0 * 30.0 * 12.0)
                    )
                )
                l.forEach { println("$numeric bytes ${it.first} (${withSuffixStorage(it.second.toLong())}):  ${it.second}") }
                println("\n\n-------------------------------------------------\n\n")
            }
            "Month" -> {
                val l = listOf(
                    "Per Year: " to Math.round(
                        ((numeric.toString().toDouble() * numericDenomination.second.toString()
                            .toDouble()).toDouble()) * (12.0)
                    ),
                    "Per Week: " to Math.round(
                        ((numeric * numericDenomination.second.toString().toDouble()).toDouble()) / (4.0)
                    ),
                    "Per Day" to Math.round(
                        ((numeric * numericDenomination.second.toString().toDouble()).toDouble()) / (30.0)
                    ),
                    "Per Hour" to Math.round(
                        ((numeric * numericDenomination.second.toString().toDouble()).toDouble()) / (30.0 * 24.0)
                    ),
                    "Per Minute" to
                            Math.round(
                                ((numeric * numericDenomination.second.toString()
                                    .toDouble()).toDouble()) / (30.0 * 24.0 * 60.0)
                            ),
                    "Per Second" to
                            Math.round(
                                ((numeric * numericDenomination.second.toString()
                                    .toDouble()).toDouble()) / (30.0 * 24.0 * 60.0 * 60.0)
                            )
                )
                l.forEach { println("$numeric bytes ${it.first} (${withSuffixStorage(it.second.toLong())}):  ${it.second}") }
                println("\n\n-------------------------------------------------\n\n")
            }
            "Day" -> {
                val l = listOf(
                    "Per Year: " to Math.round(
                        ((numeric.toString().toDouble() * numericDenomination.second.toString()
                            .toDouble()).toDouble()) * (365.0)
                    ),
                    "Per Week: " to Math.round(
                        ((numeric * numericDenomination.second.toString().toDouble()).toDouble()) * (7.0)
                    ),
                    "Per Day" to Math.round(
                        ((numeric * numericDenomination.second.toString().toDouble()).toDouble())
                    ),
                    "Per Hour" to Math.round(
                        ((numeric * numericDenomination.second.toString().toDouble()).toDouble()) / (24.0)
                    ),
                    "Per Minute" to
                            Math.round(
                                ((numeric * numericDenomination.second.toString()
                                    .toDouble()).toDouble()) / (24.0 * 60.0)
                            ),
                    "Per Second" to
                            Math.round(
                                ((numeric * numericDenomination.second.toString()
                                    .toDouble()).toDouble()) / (24.0 * 60.0 * 60.0)
                            )
                )
                l.forEach { println("$numeric bytes ${it.first} (${withSuffixStorage(it.second.toLong())}):  ${it.second}") }
                println("\n\n-------------------------------------------------\n\n")
            }
        }

    } catch (e: Exception) {
        e.printStackTrace()
        System.err.println("Invalid input!")
    }
}

while (true) {
    prompt()
}

