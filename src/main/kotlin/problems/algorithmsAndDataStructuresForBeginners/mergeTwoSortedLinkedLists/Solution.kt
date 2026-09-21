package problems.algorithmsAndDataStructuresForBeginners.mergeTwoSortedLinkedLists

class ListNode(
    var `val`: Int,
) {
    var next: ListNode? = null
}

/*
* time: O(m + n) where m is the number of elements in list1 and n is the number of elements in list2
*
* space: O(1) as the nodes already exist, we are just changing pointer values on them to change the order.
* */

class InitialSolution {
    fun mergeTwoLists(
        list1: ListNode?,
        list2: ListNode?,
    ): ListNode? {
        var i1 = list1
        var i2 = list2

        val dummy = ListNode(0)
        var insert = dummy

        while (i1 !== null && i2 !== null) {
            if (i1.`val` <= i2.`val`) {
                insert.next = i1
                insert = i1
                i1 = i1.next
            } else {
                insert.next = i2
                insert = i2
                i2 = i2.next
            }
        }

        insert.next = i1 ?: i2

        return dummy.next
    }
}
