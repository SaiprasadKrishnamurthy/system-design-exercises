object MaxScoreWords {
    @JvmStatic
    fun main(args: Array<String>) {
        val words = arrayOf("dog", "cat", "dad", "good")
        val letters = arrayOf<String?>("a", "a", "c", "d", "d", "d", "g", "o", "o")
        val scores = arrayOf(1, 0, 9, 5, 5, 5, 3, 2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0)
        val lettersClone = letters.clone()
        val maxWordScorePairs = words.map { word ->
            val computedScores = word.map { c ->
                val idx = lettersClone.indexOfFirst { it != null && c.toString() == it }
                if (idx != -1) {
                    lettersClone[idx] = null
                }
                if (idx == -1) {
                    -1
                } else {
                    println(word + " == " + c + " ==" + scores[idx])
                    scores[idx]
                }
            }
            word to computedScores
        }
            .filter { !it.second.contains(-1) }
            .map { it.first to it.second.sum() }
            .sortedByDescending { it.second }

        println(maxWordScorePairs)

    }
}