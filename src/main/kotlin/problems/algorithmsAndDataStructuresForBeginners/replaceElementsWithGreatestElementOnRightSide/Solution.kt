package problems.algorithmsAndDataStructuresForBeginners.replaceElementsWithGreatestElementOnRightSide

class Solution {
    fun replaceElements(arr: IntArray): IntArray {
        // initial max = -1
        // reverse iteration
        // new max = max(oldmax, arr[i])

        var rightMax = -1
        for (i in arr.size - 1 downTo 0) {
            var newMax = maxOf(arr[i], rightMax)
            arr[i] = rightMax
            rightMax = newMax
        }

        return arr
    }

    /*
     * time: O(n)
     * space: O(n)
     * */
}
