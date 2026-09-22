package problems.algorithmsAndDataStructuresForBeginners.climbingStairs

/*
* time complexity: for each value in 0..n we do O(1) work. It's O(1) work because of the stepMap memoization, we don't
*  repeat work we have already done. This means the total amount of work is n * O(1) which is O(n)
*
* space complexity: O(n) because the step map needs to hold n entries
* */

class PracticeSolution {
    val stepMap = mutableMapOf<Int, Int>()

    fun climbStairs(n: Int): Int {
        if (n <= 2) return n

        val answer = stepMap[n] ?: (climbStairs(n - 2) + climbStairs(n - 1))
        stepMap[n] = answer
        return answer
    }
}
