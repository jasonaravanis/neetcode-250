package problems.algorithmsAndDataStructuresForBeginners.implementStackUsingQueues

class OneQueue {
    private val q1 = ArrayDeque<Int>()

    fun push(x: Int) {
        q1.addLast(x)
        for (i in 0 until q1.size - 1) {
            q1.addLast(q1.removeFirst())
        }
    }

    fun pop(): Int? {
        if (q1.isEmpty()) return null
        return q1.removeFirst()
    }

    fun top(): Int? = q1.firstOrNull()

    fun empty(): Boolean = q1.isEmpty()
}
