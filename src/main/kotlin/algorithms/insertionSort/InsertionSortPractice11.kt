package algorithms.insertionSort

// time: worst: O(n^2) best: O(n)
// space: O(1)
// stable

class InsertionSortPractice11 {
    fun insertionSort(arr: IntArray) {
        for (i in arr.indices) {
            var j = i - 1

            while (j >= 0 && arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
                j--
            }
        }
    }
}
