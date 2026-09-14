package problems.algorithmsAndDataStructuresForBeginners.implementStackUsingQueues

/*
* time: O(1) to pop, top, empty, O(n) to push
* memory: O(n)
* */

class TwoQueues {
    private val q1 = ArrayDeque<Int>()
    private val q2 = ArrayDeque<Int>()

    fun push(x: Int) {
        q2.addLast(x)
        while (q1.isNotEmpty()) {
            q2.addLast(q1.removeFirst())
        }
        while (q2.isNotEmpty()) {
            q1.addLast(q2.removeFirst())
        }
        q2.clear()
    }

    fun pop(): Int? {
        if (q1.isEmpty()) return null
        return q1.removeFirst()
    }

    fun top(): Int? = q1.firstOrNull()

    fun empty(): Boolean = q1.isEmpty()
}
