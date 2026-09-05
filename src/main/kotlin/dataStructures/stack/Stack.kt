package dataStructures.stack
import kotlin.collections.ArrayDeque

class MinStack {
    val valuesStack = ArrayDeque<Int>()
    val minStack = ArrayDeque<Int>()

    fun push(`val`: Int) {
        valuesStack.add(`val`)
        val currentMin = minStack.lastOrNull()
        if (currentMin == null || `val` < currentMin) {
            minStack.add(`val`)
        } else {
            minStack.add(minStack.last())
        }
    }

    fun pop() {
        valuesStack.removeLast()
        minStack.removeLast()
    }

    fun top(): Int = valuesStack.last()

    fun getMin(): Int = minStack.last()
}
