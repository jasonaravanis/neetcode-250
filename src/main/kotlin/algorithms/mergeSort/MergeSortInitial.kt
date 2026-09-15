package algorithms.mergeSort

class MergeSortInitial {
    fun sort(arr: IntArray): IntArray {
        fun mergeSort(
            start: Int,
            end: Int,
        ): IntArray {
            if (start >= end) return arr
            val middle = start + (end - start) / 2
            val left = mergeSort(start, middle)
            val right = mergeSort(middle + 1, end)

            val tempArray = mutableListOf<Int>()

            var i = start
            var j = middle + 1

            while (i <= middle && j <= end) {
                if (left[i] <= right[j]) {
                    tempArray.add(left[i])
                    i++
                } else {
                    tempArray.add(right[j])
                    j++
                }
            }

            while (i <= middle) {
                tempArray.add(left[i])
                i++
            }

            while (j <= end) {
                tempArray.add(right[j])
                j++
            }

            for (k in start..end) {
                arr[k] = tempArray[k - start]
            }

            return arr
        }

        return mergeSort(0, arr.size - 1)
    }
}
