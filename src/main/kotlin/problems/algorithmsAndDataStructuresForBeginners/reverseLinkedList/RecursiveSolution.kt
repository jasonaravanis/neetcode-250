package problems.algorithmsAndDataStructuresForBeginners.reverseLinkedList

class RecursiveSolution {
    /*
     * time: O(n)
     * memory: O(n)
     *
     * Explanation: reversedListHead is always the very last element in the list. Once we get that element we pass a
     * reference to it back up through all the recursion layers. For each layer, we set the next node to point to the
     * previous node via head.next.next = head and break the former point via head.next = null
     * */

    data class ListNode(
        val value: Int,
        var next: ListNode?,
    )

    fun reverseList(head: ListNode? = null): ListNode? {
        if (head?.next == null) return head

        val reversedListHead = reverseList(head.next)

        head.next?.next = head
        head.next = null

        return reversedListHead
    }
}
