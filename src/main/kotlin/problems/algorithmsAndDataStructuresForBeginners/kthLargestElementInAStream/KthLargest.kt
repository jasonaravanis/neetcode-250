package problems.algorithmsAndDataStructuresForBeginners.kthLargestElementInAStream

import java.util.PriorityQueue

/*
* initialise time:
*   O(n log n) to sort nums
*   O(k log(k)) to add smallest k elements from nums into heap
*   n is larger than k
*
* initialise space:
*   O(k) for the sorted array
*   O(k) for the heap
*   so total = O(2k) simplifies to O(k)
*
* add time:
*   O(log(n)
* add space:
*   O(1)
* */

class KthLargest(
    private val k: Int,
    nums: IntArray,
) {
    private val heap = PriorityQueue<Int>()

    init {
        val sortedNums = nums.sortedArrayDescending().take(k)
        heap.addAll(sortedNums)
    }

    fun add(`val`: Int): Int {
        heap.add(`val`)
        if (heap.size > k) heap.poll()
        return heap.peek()
    }
}
