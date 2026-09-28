package algorithms.bucketSort

class Solution {
    // Assume we are told arr only includes fours, fives, and sixes
    fun bucketSort(arr: IntArray) {
        val countStore = intArrayOf(0, 0, 0)

        val valueToArrayIndexMap = mapOf(4 to 0, 5 to 1, 6 to 2)

        for (number in arr) {
            val index = valueToArrayIndexMap[number]
            if (index != null) countStore[index]++
        }

        var i = 0
        for ((index, count) in countStore.withIndex()) {
            repeat(count) {
                when (index) {
                    0 -> arr[i++] = 4
                    1 -> arr[i++] = 5
                    2 -> arr[i++] = 6
                }
            }
        }

        val r = Int.MAX_VALUE
    }
}
