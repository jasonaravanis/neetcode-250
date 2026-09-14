package problems.algorithmsAndDataStructuresForBeginners.designBrowserHistory

class BrowserHistory(
    homepage: String,
) {
    private data class Node(
        val `val`: String,
        var next: Node? = null,
        var previous: Node? = null,
    )

    private var current: Node = Node(homepage)

    fun visit(url: String) {
        val newNode = Node(url)
        newNode.previous = current
        current.next = newNode
        current = newNode
    }

    fun back(steps: Int): String {
        repeat(steps) {
            val prev = current.previous ?: return current.`val`
            current = prev
        }

        return current.`val`
    }

    fun forward(steps: Int): String {
        repeat(steps) {
            val next = current.next ?: return current.`val`
            current = next
        }
        return current.`val`
    }
}
