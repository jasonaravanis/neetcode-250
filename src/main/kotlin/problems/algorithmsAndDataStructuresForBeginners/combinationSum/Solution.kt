package problems.algorithmsAndDataStructuresForBeginners.combinationSum

class Solution {
    fun combinationSum(
        nums: IntArray,
        target: Int,
    ): List<List<Int>> {
        val answerSet = mutableListOf<List<Int>>()
        val curset = mutableListOf<Int>()

        helper(nums, target, 0, curset, answerSet)
        return answerSet
    }

    private fun helper(
        nums: IntArray,
        target: Int,
        startIndex: Int,
        curset: MutableList<Int>,
        answerSet: MutableList<List<Int>>,
    ) {
        if (curset.sum() > target) {
            return
        }
        if (curset.sum() == target) {
            val answer = curset.toList()
            answerSet.add(answer)
            return
        }
        if (startIndex > nums.size - 1) {
            return
        }

        val candidate = nums[startIndex]
        curset.add(candidate)
        helper(nums, target, startIndex, curset, answerSet)
        curset.removeLast()
        helper(nums, target, startIndex + 1, curset, answerSet)
    }
}
