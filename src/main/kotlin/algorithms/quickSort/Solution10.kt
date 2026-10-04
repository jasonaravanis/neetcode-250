package algorithms.quickSort

// time: on average, if pivot is in the mid range, then the number of recursive cycles is log(n) and for each cycle
// we do n work in the while loop, so average time complexity: O(n * log(n))
// but in the worst case (i.e  an ordered list where pivot is always the largest/smallest value) then recursive
// cycles would be n and time complexity would be O(n^2)

// space: average O(log(n)) for recursive stack, worst cast O(n)

class Solution10 {
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
            if (arr[j] < pivot) {
                val temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
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
