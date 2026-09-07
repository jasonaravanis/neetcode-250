package dataStructures.doublyLinkedList

class MyLinkedList {
    private data class Node(
        var next: Node? = null,
        var previous: Node? = null,
        var `val`: Int,
    )

    private val left = Node(`val` = 0)
    private val right = Node(`val` = 0)

    init {
        left.next = right
        right.previous = left
    }

    private var head: Node? = null
    private var tail: Node? = null

    private var listLength = 0

    fun get(index: Int): Int {
        var current = left.next
        var i = index
        while (current != null && i > 0) {
            current = current.next
            i -= 1
        }
        if (current !== null && current !== right && i == 0) {
            return current.`val`
        }
        return -1
    }

    fun addAtHead(`val`: Int) {
        val node = Node(`val` = `val`)
        val previous = left
        val next = left.next

        previous.next = node
        next?.previous = node
        node.next = next
        node.previous = previous
    }

    fun addAtTail(`val`: Int) {
        val node = Node(`val` = `val`)
        val previous = right.previous
        val next = right

        previous?.next = node
        next.previous = node
        node.next = next
        node.previous = previous
    }

    fun addAtIndex(
        index: Int,
        `val`: Int,
    ) {
        var current = left.next
        var i = index
        while (current !== null && i > 0) {
            current = current.next
            i -= 1
        }
        if (current !== null && i == 0) {
            val node = Node(`val` = `val`)
            val previous = current.previous
            val next = current

            previous?.next = node
            next.previous = node
            node.next = next
            node.previous = previous
        }
    }

    fun deleteAtIndex(index: Int) {
        var current = left.next
        var i = index
        while (current !== null && i > 0) {
            current = current.next
            i -= 1
        }
        if (current !== null && current !== right && i == 0) {
            val previous = current.previous
            val next = current.next

            next?.previous = previous
            previous?.next = next
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * var obj = MyLinkedList()
 * var param_1 = obj.get(index)
 * obj.addAtHead(`val`)
 * obj.addAtTail(`val`)
 * obj.addAtIndex(index,`val`)
 * obj.deleteAtIndex(index)
 */
