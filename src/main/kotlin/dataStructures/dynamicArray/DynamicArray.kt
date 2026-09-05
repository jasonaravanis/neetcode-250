package dataStructures.dynamicArray

class DynamicArray(
    capacity: Int,
) {
    private var dynamicCapacity = capacity
    private var staticArray = IntArray(capacity)
    private var writeIndex = 0

    fun get(i: Int): Int = staticArray[i]

    fun set(
        i: Int,
        n: Int,
    ) {
        staticArray[i] = n
    }

    fun pushback(n: Int) {
        if (writeIndex == staticArray.size) {
            this.resize()
        }
        staticArray[writeIndex] = n
        writeIndex++
    }

    fun popback(): Int {
        val last = staticArray[writeIndex - 1]
        staticArray[writeIndex - 1] = 0
        writeIndex--
        return last
    }

    private fun resize() {
        val newStaticArray = IntArray(dynamicCapacity * 2)
        for ((i, v) in staticArray.withIndex()) {
            newStaticArray[i] = v
        }
        staticArray = newStaticArray
        dynamicCapacity *= 2
    }

    fun getSize(): Int = writeIndex

    fun getCapacity(): Int = dynamicCapacity
}
