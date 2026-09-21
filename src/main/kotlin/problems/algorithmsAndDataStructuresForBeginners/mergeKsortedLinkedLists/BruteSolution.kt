package problems.algorithmsAndDataStructuresForBeginners.mergeKsortedLinkedLists

/*
* time: O(n) to make the single unsorted list, O(n * log(n)) to do the sort, O(n) to convert the List<Int> back into a
* linked list using ListNode class. The dominant factor is the sort, so overall time complexity simplifies to
* O(n * log(n))
*
* memory:  O(n) for the values list, O(n) for the linked list. Simplifies to O(n).
* */

class BruteSolution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val values =
            buildList {
                for (list in lists) {
                    var current = list
                    while (current != null) {
                        add(current.`val`)
                        current = current.next
                    }
                }
            }.sorted()

        val dummy = ListNode(0)
        var current = dummy

        for (value in values) {
            current.next = ListNode(value).also { current = it }
        }

        return dummy.next
    }
}
