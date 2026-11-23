package problems.algorithmsAndDataStructuresForBeginners.kthLargestElementInAnArray

import java.util.PriorityQueue

// time: O(n log(k)) to create the heap
// space: O(k)

class Solution {
    fun findKthLargest(
        nums: IntArray,
        k: Int,
    ): Int {
        val minHeap = PriorityQueue<Int>()

        nums.forEach {
            minHeap.add(it)
            if (minHeap.size > k) minHeap.poll()
        }

        return minHeap.peek()
    }
}
