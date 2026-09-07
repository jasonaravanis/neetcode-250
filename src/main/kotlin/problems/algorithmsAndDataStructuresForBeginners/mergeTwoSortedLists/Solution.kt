package problems.algorithmsAndDataStructuresForBeginners.mergeTwoSortedLists

class ListNode(
    var `val`: Int,
) {
    var next: ListNode? = null
}

class Solution {
    fun mergeTwoLists(
        list1: ListNode?,
        list2: ListNode?,
    ): ListNode? {
        val dummy = ListNode(0)
        var tail: ListNode = dummy

        var l1 = list1
        var l2 = list2

        while (l1 !== null && l2 !== null) {
            if (l1.`val` < l2.`val`) {
                tail.next = l1
                tail = l1
                l1 = l1.next
            } else {
                tail.next = l2
                tail = l2
                l2 = l2.next
            }
        }

        if (l1 == null && l2 !== null) {
            tail.next = l2
        }

        if (l2 == null && l1 !== null) {
            tail.next = l1
        }

        return if (dummy.next != null) dummy.next else null
    }
}
