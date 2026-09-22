package problems.algorithmsAndDataStructuresForBeginners.designBrowserHistory

class BrowserHistory3(
    val homepage: String,
) {
    private data class ListNode(
        val `val`: String,
    ) {
        var next: ListNode? = null
        var previous: ListNode? = null
    }

    private val head = ListNode(homepage)
    private var current = head

    fun visit(url: String) {
        val node = ListNode(url)
        current.next = node
        node.previous = current
        current = node
    }

    fun back(steps: Int): String {
        var i = steps
        while (i > 0) {
            current = current.previous ?: break
            i--
        }
        return current.`val`
    }

    fun forward(steps: Int): String {
        var i = steps
        while (i > 0) {
            current = current.next ?: break
            i--
        }
        return current.`val`
    }
}
