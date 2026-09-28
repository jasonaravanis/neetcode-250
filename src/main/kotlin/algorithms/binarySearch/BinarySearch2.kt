package algorithms.binarySearch

class BinarySearch2 {
    fun binarySearch(
        arr: IntArray,
        target: Int,
    ): Int {
        var l = 0
        var r = arr.size - 1

        while (l <= r) {
            val m = (l + r) / 2
            when {
                arr[m] < target -> l = m + 1
                arr[m] > target -> r = m - 1
                else -> return m
            }
        }
        return -1
    }
}
