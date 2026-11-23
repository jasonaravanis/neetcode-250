package problems.algorithmsAndDataStructuresForBeginners.lastStoneWeight

import java.util.PriorityQueue

class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val maxHeap = PriorityQueue<Int>(compareByDescending { it })

        maxHeap.addAll(stones.toList())

        while (maxHeap.size > 1) {
            val x = maxHeap.poll()
            val y = maxHeap.poll()
            val z = x - y
            if (z > 0) {
                maxHeap.add(z)
            }
        }

        return if (maxHeap.size == 1) maxHeap.poll() else 0
    }
}
