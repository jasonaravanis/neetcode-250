package dataStructures.doublyLinkedList

class DoublyLinkedListSecondAttempt {
    private data class Node(
        var `val`: Int,
        var next: Node? = null,
        var previous: Node? = null,
    )

    private val left = Node(0)
    private val right = Node(0)

    fun get(index: Int): Int {
        var current: Node? = left.next
        var i = 0

        while (i != index && current !== null && current.next !== right) {
            current = current.next
            i++
        }

        if (i == index && current !== null) {
            return current.`val`
        }
        return -1
    }

    fun addAtHead(`val`: Int) {
        val node = Node(`val` = `val`)
        val oldHead = left.next

        left.next = node
        oldHead?.previous = node
        node.previous = left
        node.next = oldHead
    }

    fun addAtTail(`val`: Int) {
        val node = Node(`val` = `val`)
        val oldTail = right.previous

        oldTail?.next = node
        right.previous = node
        node.previous = oldTail
        node.next = right
    }

    fun addAtIndex(
        index: Int,
        `val`: Int,
    ) {
        var current = left.next
        var i = index
        while (current !== null && i > 0) {
            current = current.next
            i--
        }

        val previousNode = current?.previous
        val nextNode = current
        val node = Node(`val`)

        previousNode?.next = node
        nextNode?.previous = node
        node.previous = previousNode
        node.next = nextNode
    }

    fun deleteAtIndex(index: Int) {
        var current = left.next
        var i = index

        while (current !== null && i > 0) {
            current = current.next
            i--
        }

        if (current !== right && i == 0) {
            current?.previous?.next = current?.next
            current?.next?.previous = current?.previous
        }
    }
}
