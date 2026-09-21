package problems.algorithmsAndDataStructuresForBeginners.mergeKsortedLinkedLists

/*
* time: O(k * n) where k is the number of lists and n is the number of total nodes across all the lists
*
* the while loop runs n times, each time the loop runs we append one node. So if there are 10 nodes, the while loop
*  runs 10 times. Each time the while loop runs, we need to iterate across the first element in k lists.
*
* So n iterations, and in each iteration k operations, means time complexity overall is O(n*k)
*
*
* space: O(1) - no new memory structure created, just manipulating pointers on the existing ListNodes
* */

class IterativeSolution {
    fun isListsEmpty(lists: Array<ListNode?>): Boolean {
        for (element in lists) {
            if (element !== null) return false
        }
        return true
    }

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val dummy: ListNode = ListNode(0)
        var tail: ListNode = dummy

        while (!isListsEmpty(lists)) {
            var minIndex: Int = -1
            var minNode: ListNode? = null
            for (i in lists.indices) {
                val current = lists[i] ?: continue
                if (minNode == null || current.`val` < minNode.`val`) {
                    minIndex = i
                    minNode = current
                }
            }
            if (minNode !== null) {
                lists[minIndex] = minNode.next
                tail.next = minNode
                tail = minNode
                tail.next = null
            }
        }

        return dummy.next
    }
}
