package problems.algorithmsAndDataStructuresForBeginners.subsets

class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        // nums is an array of unique integers

        val subsets = mutableListOf<List<Int>>()
        val curset = mutableListOf<Int>()

        helper(0, nums, subsets, curset)

        return subsets
    }

    private fun helper(
        index: Int,
        nums: IntArray,
        subsets: MutableList<List<Int>>,
        curset: MutableList<Int>,
    ) {
        if (index >= nums.size) {
            val cursetCopy = curset.toList()
            subsets.add(cursetCopy)
            return
        }

        curset.add(nums[index])
        helper(index + 1, nums, subsets, curset)
        curset.removeLast()
        helper(index + 1, nums, subsets, curset)
    }
}
