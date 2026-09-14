package problems.algorithmsAndDataStructuresForBeginners.climbingStairs

class InitialSolution {
    /*
     * time: O(n). Higher n causes more layers in the tree. This would normally be O(2^n). But because we memoize
     * the values we've already computed, recomputing those values is O(1). So we just need to calculate valeus we
     * haven't calculated yet. Which is O(n).
     * memory: O(n). n for the mutable map, n for the recursion stack. 2n simplifies to n.
     * */

    val climbStairsMap = mutableMapOf<Int, Int>()

    fun climbStairs(n: Int): Int {
        if (n == 0) return 1
        if (n < 0) return 0

        if (climbStairsMap.containsKey(n)) {
            return climbStairsMap.getValue(n)
        }

        val pathsAfterOneStep = climbStairs(n - 1)
        val pathsAfterTwoStep = climbStairs(n - 2)

        val answer = pathsAfterOneStep + pathsAfterTwoStep

        if (!climbStairsMap.containsKey(n)) {
            climbStairsMap[n] = answer
        }

        return answer
    }
}
