package algorithms.quickSort

class Solution6 {
    fun sort(
        arr: IntArray,
        start: Int,
        end: Int,
    ) {
        if (start >= end) return

        val pivotIndex = medianOfThreeIndex(arr, start, end)

        val temp = arr[pivotIndex]
        arr[pivotIndex] = arr[end]
        arr[end] = temp

        val pivot = arr[end]
        var j = start
        var i = start

        while (j < end) {
            if (arr[j] < pivot) {
                val t = arr[j]
                arr[j] = arr[i]
                arr[i] = t
                i++
            }
            j++
        }

        arr[end] = arr[i]
        arr[i] = pivot

        sort(arr, start, i - 1)
        sort(arr, i + 1, end)
    }

    private fun medianOfThreeIndex(
        arr: IntArray,
        start: Int,
        end: Int,
    ): Int {
        val mid = start + (end - start) / 2
        val a = arr[start]
        val b = arr[mid]
        val c = arr[end]

        return when {
            (a <= b && b <= c) || (c <= b && b <= a) -> mid
            (b <= a && a <= c) || (c <= a && a <= b) -> start
            else -> end
        }
    }

    fun quickSort(arr: IntArray) {
        sort(arr, 0, arr.size - 1)
    }
}
