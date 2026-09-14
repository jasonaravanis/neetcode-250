package algorithms.insertionSort

class InsertionSort {
    /*
     * time: O(n^2)
     * memory: O(1)
     * */

    fun sort(arr: IntArray): IntArray {
        for (i in 1 until arr.size) {
            var j = i - 1
            while (j > 0 && arr[j] > arr[j + 1]) {
                var temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
                j -= 1
            }
        }

        return arr
    }

    val mutable = mutableListOf<Int>()
    val immutable = mutable.toList()
}
