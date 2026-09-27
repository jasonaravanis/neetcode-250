package algorithms.quickSort

/*
* Quick sort works by selecting a pivot element (in this case, the last element) and rearranging the array so all
* elements smaller or equal to that element are on the left, and all elements that are greater are on the right.
*
* Then is recurses and repeats on the sub arrays.
*
* If the pivot element happens to be close to the median of the array values, then the number of recursive layers
* will be log(n). If the pivot is always the smallest or largest element, then the number of recursive
*  layers will be n (this could happen if the list is already sorted or is in reverse sorted order).
*
* For each recursive layer we do O(n) operations
*
* On average the pivot should be somewhere in the middle, so the average time complexity is O(n * log(n))
*
* In the worst case, the time complexity is O(n * n) i.e O(n^2)
*
* The space complexity is O(log(n)) in the average case, because the number of recursive layers in memory grows
*  with list length n.
*
* In the worst case where the pivot is always the min or max value, the number of recursive layers is n so the space
* complexity is O(n)
* */

class Solution {
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
            if (arr[j] <= pivot) {
                val temp = arr[j]
                arr[j] = arr[i]
                arr[i] = temp
                i++
            }
            j++
        }

        val temp = arr[i]
        arr[i] = pivot
        arr[end] = temp

        sort(arr, start, i - 1)
        sort(arr, i + 1, end)
    }

    fun quickSort(arr: IntArray) = sort(arr, 0, arr.size - 1)
}
