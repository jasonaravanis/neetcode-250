package algorithms.insertionSort

class InsertionSortPractice {
    fun sort(arr: IntArray) {
        for (i in 1 until arr.size) {
            var j = i - 1
            while (j >= 0 && arr[j + 1] < arr[j]) {
                val temp = arr[j + 1]
                arr[j + 1] = arr[j]
                arr[j] = temp
                j--
            }
        }
    }
}
