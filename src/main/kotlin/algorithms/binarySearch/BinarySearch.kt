package algorithms.binarySearch

/*
* Iterative binary search
*
* time: O(log(n))
* space: O(1)
* */

class BinarySearch {
    fun search(
        nums: IntArray,
        target: Int,
    ): Int {
        var l = 0
        var r = nums.size - 1

        while (l <= r) {
            val m = (l + r) / 2
            when {
                nums[m] == target -> return m
                nums[m] < target -> l = m + 1
                nums[m] > target -> r = m - 1
            }
        }
        return -1
    }
}
