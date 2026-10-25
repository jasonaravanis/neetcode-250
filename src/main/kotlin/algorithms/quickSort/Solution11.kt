package algorithms.quickSort

// time: worst: O(n^2) average: O(n * log(n))
// space: worst: O(n) average: O(log(n))

class Solution11 {
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
            a in b..c || a in c..b -> start
            b in a..c || b in c..a -> middle
            else -> end
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

        var i = start
        var j = start

        while (j < end) {
            if (arr[j] <= pivotValue) {
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
