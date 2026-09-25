package problems.algorithmsAndDataStructuresForBeginners.implementStackUsingQueues

class PracticeTwoSolution {
    /*
     * the question is asking us to implement a LIFO stack, i.e last in first out
     *
     * but we can only use up to two queues, which are FIFO (first in first out).
     *
     * When we push element i, we cycle all existing elements from in front to behind i
     * */

    val store = ArrayDeque<Int>()
//    val temp = ArrayDeque<Int>()

    // An alternative with one queue

    fun push(x: Int) {
        store.addLast(x)

        for (i in 0 until store.size - 1) {
            store.addLast(store.removeFirst())
        }
    }

//    fun push(x: Int) {
//        while (!store.isEmpty()) {
//            temp.addLast(store.removeFirst())
//        }
//        store.addLast(x)
//        while (!temp.isEmpty()) {
//            store.addLast(temp.removeFirst())
//        }
//    }

    fun pop(): Int = store.removeFirst()

    fun top(): Int = store.first()

    fun empty(): Boolean = store.isEmpty()
}
