package algorithms.quickSort

class Solution7 {
    fun getMedianPivotIndex(
        arr: IntArray,
        start: Int,
        end: Int,
    ): Int {
        val middle = start + (end - start) / 2
        val a = arr[start]
        val b = arr[middle]
        val c = arr[end]

        return when {
            a <= b && b <= c || c <= b && b <= a -> middle
            a <= c && c <= b || b <= c && c <= a -> end
            else -> start
        }
    }

    fun sort(
        arr: IntArray,
        start: Int,
        end: Int,
    ) {
        if (start >= end) return

        val pivotIndex = getMedianPivotIndex(arr, start, end)

        val pivotValue = arr[pivotIndex]
        arr[pivotIndex] = arr[end]
        arr[end] = pivotValue

        var j = start
        var i = start

        while (j < end) {
            if (arr[j] < pivotValue) {
                val temp = arr[j]
                arr[j] = arr[i]
                arr[i] = temp
                i++
            }
            j++
        }

        arr[end] = arr[i]
        arr[i] = pivotValue

        sort(arr, start, i - 1)
        sort(arr, i + 1, end)
    }

    fun quickSort(arr: IntArray) {
        sort(arr, 0, arr.size - 1)
    }
}
