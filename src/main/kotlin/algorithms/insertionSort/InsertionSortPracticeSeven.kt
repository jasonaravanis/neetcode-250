package algorithms.insertionSort

/*
* time: O(n^2) if list is in reverse order
* space: O(1)
* */

class InsertionSortPracticeSeven {
    fun insertionSort(arr: IntArray) {
        for (i in 1 until arr.size) {
            var j = i - 1
            while (j >= 0 && arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = arr[j]
                j--
            }
        }
    }
}
