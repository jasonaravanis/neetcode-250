package problems.p001concatenationofarray

class Solution {
    fun getConcatenation(nums: IntArray): IntArray {
        val ans = mutableListOf<Int>()

        repeat(2) {
            ans.addAll(nums.toList())
        }
        return ans.toIntArray()
    }
}
