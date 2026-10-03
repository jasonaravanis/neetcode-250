package algorithms.quickSort

/*
WITHOUT MEDIAN PIVOT CHECK
* time: O(n * log(n)) on average (assuming pivot is usually somewhere in the middle of the range of value in arr
*       could be O(n^2) in the worst case (arr is in sorted order, i.e pivot is always the greatest value)
*
* space: O(h) where h is height of recursion stack, on average log(n) assuming pivot usually falls in the mid range
*        in worst case (already sorted order) space complexity would be O(n) due to the recursion stack
*
*
* quick sort gives us possibly worse time complexity than mergesort, but it also gives us possibly better space complexity

WITH MEDIAN PIVOT CHECK - worst case is less likely but still theoretically possible
time: O(n * log(n)) average case
space: O(log(n)) average case
* */

class Solution9 {
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

    fun sortWithMedianPivot(
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

        sortWithMedianPivot(arr, start, i - 1)
        sortWithMedianPivot(arr, i + 1, end)
    }

    fun sort(
        arr: IntArray,
        start: Int,
        end: Int,
    ) {
        if (start >= end) return

        val pivotValue = arr[end]

        var i = start
        var j = start

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
        sortWithMedianPivot(arr, 0, arr.size - 1)
    }
}
