package problems.p001_concatenation_of_an_array

class Solution {
    fun getConcatenation(nums: IntArray): IntArray {
        val ans = IntArray(nums.size * 2)
        for (i in nums.indices) {
            ans[i] = nums[i]
            ans[i + nums.size] = nums[i]
        }
        return ans
    }
}
