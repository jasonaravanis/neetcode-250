package problems.algorithmsAndDataStructuresForBeginners.reverseLinkedList

class ListNode(
    var `val`: Int,
) {
    var next: ListNode? = null
}

class Solution {
    /*
     * Time: O(n)
     * Memory: O(1)
     * */
    fun reverseListIterative(head: ListNode?): ListNode? {
        var current = head
        var previous: ListNode? = null

        while (current != null) {
            var next = current.next
            current.next = previous
            previous = current
            current = next
        }

        return previous
    }

    /*
     * Time: O(n)
     * Memory: O(n)
     * */
    fun reverseListRecursive(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }

        var newHead = head
        if (newHead.next != null) {
            newHead = reverseListRecursive(head.next)
            head.next?.next = head
            head.next = null
        }

        return newHead
    }
}

//
// var previous: ListNode? = null
// var current = head
//
// while (current != null) {
//    val next = current.next
//    current.next = previous
//    previous = current
//    current = next
// }
//
// return previous
