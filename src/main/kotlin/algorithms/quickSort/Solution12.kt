package algorithms.quickSort

// time: average: O(n * log(n)) worst: O(n^2)
// space: average: O(log(n)) worst: O(n)

// not stable

class Solution12 {
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
                val temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
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
