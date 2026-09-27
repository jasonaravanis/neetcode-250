package algorithms.quickSort

class Solution3 {
    fun sort(
        arr: IntArray,
        start: Int,
        end: Int,
    ) {
        if (start >= end) return

        val pivot = arr[end]

        var i = start
        var j = start

        while (j < end) {
            if (arr[j] <= pivot) {
                val temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
                i++
            }
            j++
        }

        arr[end] = arr[i]
        arr[i] = pivot

        sort(arr, start, i - 1)
        sort(arr, i + 1, end)
    }

    fun quickSort(arr: IntArray) {
        sort(arr, 0, arr.size - 1)
    }
}
