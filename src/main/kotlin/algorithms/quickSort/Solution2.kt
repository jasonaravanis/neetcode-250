package algorithms.quickSort

class Solution2 {
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
                val temp = arr[j]
                arr[j] = arr[i]
                arr[i] = temp
                i++
            }
            j++
        }

        val temp = arr[i]
        arr[i] = arr[end]
        arr[end] = temp

        sort(arr, start, i - 1)
        sort(arr, i + 1, end)
    }

    fun quickSort(arr: IntArray) {
        sort(arr, 0, arr.size - 1)
    }
}
