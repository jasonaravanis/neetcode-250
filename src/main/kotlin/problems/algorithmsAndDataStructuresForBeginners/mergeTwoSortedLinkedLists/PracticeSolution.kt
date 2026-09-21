package problems.algorithmsAndDataStructuresForBeginners.mergeTwoSortedLinkedLists

class PracticeSolution {
    fun merge(
        list1: ListNode?,
        list2: ListNode?,
    ): ListNode? {
        val sentinel = ListNode(0)
        var tail = sentinel
        var l1 = list1
        var l2 = list2

        while (l1 != null && l2 != null) {
            var node: ListNode?
            if (l1.`val` <= l2.`val`) {
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
}
