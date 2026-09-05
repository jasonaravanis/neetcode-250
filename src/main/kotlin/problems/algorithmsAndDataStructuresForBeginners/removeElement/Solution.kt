package problems.algorithmsAndDataStructuresForBeginners.removeElement

class Solution {
    fun removeElement(
        nums: IntArray,
        `val`: Int,
    ): Int {
        var read = 0
        var write = 0
        for (i in nums.indices) {
            if (nums[i] != `val`) {
                nums[write] = nums[i]
                write++
            }
        }

        return write
    }
}
