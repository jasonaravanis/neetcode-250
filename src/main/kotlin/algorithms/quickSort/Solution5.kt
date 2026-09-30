package algorithms.quickSort

/*
* Time complexity:
*   For each level in the recursion tree we do O(n) work (the while loop, scanning across some subsection of the total
*   array. The number of levels in the recursion tree dictates how many times we do the O(n) work. On average, our pivot
*   should fall somewhere in the middle of the range of elements in the array. So we divide the array roughly in half
*   at each recursion layer. This would happen log(n) times, so average time complexity is O(n * log(n))
*
*   In the worst case, the pivot is always at the edge of the range, meaning each recursion layer only handles one
*   element. This means we have n recursion layers, so time complexity is O(n * n) or O(n^2)
* *
* Space complexity: recursive algorithm so O(h) for height of the recursive stack, which would be O(log(n)) in the
* average case and O(n) in the worst case
* */

class Solution5 {
    fun sort(
        arr: IntArray,
        start: Int,
        end: Int,
    ) {
        if (start >= end) return

        val pivot = arr[end]
        var j = start
        var i = start

        while (j < end) {
            if (arr[j] < pivot) {
                val temp = arr[j]
                arr[j] = arr[i]
                arr[i] = temp
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
