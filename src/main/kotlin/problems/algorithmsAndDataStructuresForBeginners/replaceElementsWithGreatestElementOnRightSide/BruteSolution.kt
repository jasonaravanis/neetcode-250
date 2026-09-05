package problems.algorithmsAndDataStructuresForBeginners.replaceElementsWithGreatestElementOnRightSide

class Solution {
    fun replaceElements(arr: IntArray): IntArray {
        /*
        loop over each element
            get subarray
            if subarray.size is 0, set arr[i] to -1
            else find max in subarray
            set arr[i] to max
        return the array

        For each n in array length we have to do more work in each pass, so this solution is time O(n^2)

         */
        for ((i, v) in arr.withIndex()) {
            val range = i..arr.size - 1
            if (range.isEmpty()) {
                arr[i] = -1
            } else {
                val max = range.maxOf { arr[it] }
                arr[i] = max
            }
        }

        return arr
    }
}
