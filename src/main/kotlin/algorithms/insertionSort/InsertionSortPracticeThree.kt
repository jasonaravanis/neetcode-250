package algorithms.insertionSort

class InsertionSortPracticeThree {
    fun insertionSort(arr: IntArray) {
        for (i in 1 until arr.size) {
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
