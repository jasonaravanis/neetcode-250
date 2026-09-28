package algorithms.quickSort

class Solution4 {
    fun sort(
        arr: IntArray,
        start: Int,
        end: Int,
    ) {
        if (start >= end) return

        val pivot = arr[end]

        var j = start
        var i = start

        while (j < end) {
            if (arr[j] <= pivot) {
                val temp = arr[j]
                arr[j] = arr[i]
                arr[i] = temp
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
