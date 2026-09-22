package problems.algorithmsAndDataStructuresForBeginners.climbingStairs

/*
* when comput climbStairs(n) we only need to know climbStairs(n-1) and climbStairs(n-2)
*
* So we can use an array with only two values
*
* time: O(n)
* space: O(1)
* */

class SpaceOptimised {
    fun climbStairs(n: Int): Int {
        if (n <= 2) return n
        val arr = IntArray(2)
        arr[0] = 1
        arr[1] = 2

        var stepsRemaining = n - 2

        while (stepsRemaining > 0) {
            val temp = arr[0] + arr[1]
            arr[0] = arr[1]
            arr[1] = temp
            stepsRemaining--
        }
        return arr[1]
    }
}
