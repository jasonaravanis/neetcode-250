package problems.algorithmsAndDataStructuresForBeginners.mergeSortedArrays

class InitialSolution {
    fun merge(
        nums1: IntArray,
        m: Int,
        nums2: IntArray,
        n: Int,
    ) {
        /*
        we could just overwrite the 0s with the nums2 values,
        then implement a merge sort to get O(n*log n) time complexity

        time complexity: O((m+n)*log(m+n))
        memory complexity: O(m+n)

         */

        /*
        we could make a new array, copy each of the elements into it
        this is time: O(m+n) memory: O(m)
         * */

        val nums1Values = nums1.take(m).toIntArray()

        var i = 0
        var j = 0
        var k = 0

        while (i < m && j < n) {
            nums1[k++] = if (nums1Values[i] <= nums2[j]) nums1Values[i++] else nums2[j++]
        }

        while (i < m) {
            nums1[k++] = nums1Values[i++]
        }

        while (j < n) {
            nums1[k++] = nums2[j++]
        }
    }
}
