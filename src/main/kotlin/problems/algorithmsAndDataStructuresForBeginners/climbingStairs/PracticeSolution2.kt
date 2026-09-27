package problems.algorithmsAndDataStructuresForBeginners.climbingStairs

class PracticeSolution2 {
    fun climbStairs(steps: Int): Int {
        if (steps <= 2) return steps

        val pointers = intArrayOf(1, 2)

        for (i in 0 until steps - 2) {
            val new = pointers[0] + pointers[1]
            pointers[0] = pointers[1]
            pointers[1] = new
        }
        return pointers[1]
    }
}
