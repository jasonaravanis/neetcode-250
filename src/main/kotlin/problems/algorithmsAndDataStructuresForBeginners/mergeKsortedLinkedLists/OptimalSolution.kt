package problems.algorithmsAndDataStructuresForBeginners.mergeKsortedLinkedLists

/*
n: number of elements across all lists
k: number of lists

* time: mergeLists is O(a+b) where a+b is total elements across two lists being merged
*       each time the while loop runs the number of mergeLists operations divides in half
        because each pair of lists is combined into a single list.
        So how many times does the while loop occur?
        It's how many times we can divide k by two until we get to 1
        which is log (k)

        so time complexity is O(n * log(k))
* */

class OptimalSolution {
    fun mergeLists(
        list1: ListNode?,
        list2: ListNode?,
    ): ListNode? {
        val dummy = ListNode(0)
        var current = dummy
        var l1 = list1
        var l2 = list2

        while (l1 != null && l2 != null) {
            var node: ListNode
            if (l1.`val` <= l2.`val`) {
                node = l1
                l1 = l1.next
            } else {
                node = l2
                l2 = l2.next
            }
            current.next = node
            current = node
        }

        current.next = l1 ?: l2

        return dummy.next
    }

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null

        var temp = lists.clone().toMutableList()

        while (temp.size > 1) {
            var mergedLists = mutableListOf<ListNode?>()
            for (i in temp.indices step 2) {
                var list1 = temp[i]
                var list2 = temp.getOrNull(i + 1)
                val merged = mergeLists(list1, list2)
                mergedLists.add(merged)
            }
            temp = mergedLists
        }

        return temp[0]
    }
}
