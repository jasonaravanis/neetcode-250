package problems.algorithmsAndDataStructuresForBeginners.mergeKsortedLinkedLists

/*
* brute: merge all lists into one, and sort.
*   time: O(n * log(n))
*   space: O(n)
*
* iterative: take smallest element one at a time from each
*   time: O(n * k)
*   space: O(n)
*
* optimal: merge each list with the one next to it, halving the number of lists each time until only one list left
*   time: O(n * log(k))
*   space: each time we generate a new batch of merged lists we need to store it in a temporary variable.
    Each element is the head of a linked list
    The number starts at k/2 and divides by two each time

    so space is O(log(k))
* */

class Practice2 {
    fun merge(
        list1: ListNode?,
        list2: ListNode?,
    ): ListNode? {
        val sentinel = ListNode(0)
        var tail = sentinel
        var l1 = list1
        var l2 = list2

        while (l1 != null && l2 != null) {
            var node: ListNode? = null
            if (l1.`val` < l2.`val`) {
                node = l1
                l1 = l1.next
            } else {
                node = l2
                l2 = l2.next
            }
            tail.next = node
            tail = node
        }

        tail.next = l1 ?: l2

        return sentinel.next
    }

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null
        var store = lists.toMutableList()

        while (store.size > 1) {
            val temp = mutableListOf<ListNode?>()
            for (i in store.indices step 2) {
                val left = store[i]
                val right = store.getOrNull(i + 1)
                val sorted = merge(left, right)
                temp.add(sorted)
            }
            store = temp
        }

        return store.first()
    }
}
