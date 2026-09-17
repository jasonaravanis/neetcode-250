package algorithms.mergeSort

class MergeSortPractice {
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
            temp[k++] = arr[j++]
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
        if (end <= start) return

        val middle = start + (end - start) / 2
        sort(arr, start, middle)
        sort(arr, middle + 1, end)

        merge(arr, start, middle, end)
    }

    fun mergeSort(arr: IntArray) {
        sort(arr, 0, arr.size - 1)
    }
}
