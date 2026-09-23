package algorithms.mergeSort

class MergeSortPractice3 {
    fun merge(
        arr: IntArray,
        start: Int,
        middle: Int,
        end: Int,
    ) {
        val temp = IntArray(end - start + 1)
        var i = start
        var j = middle + 1
        var k = 0

        while (i <= middle && j <= end) {
            temp[k++] = if (arr[i] <= arr[j]) arr[i++] else arr[j++]
        }
        while (i <= middle) {
            temp[k++] = arr[i++]
        }
        while (j <= end) {
            temp[k++] = arr[k++]
        }
        for (t in temp.indices) {
            arr[start + t] = temp[t]
        }
    }

    fun sort(
        arr: IntArray,
        start: Int,
        end: Int,
    ) {
        if (start >= end) return

        val middle = start + (end - start) / 2

        sort(arr, start, middle)
        sort(arr, middle + 1, end)

        merge(arr, start, middle, end)
    }

    fun mergeSort(arr: IntArray) {
        val start = 0
        val end = arr.size - 1

        sort(arr, start, end)
    }
}
