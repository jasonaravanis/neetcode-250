package problems.algorithmsAndDataStructuresForBeginners.mergeSortedArrays

class Solution {
    /*
    The key insight is there is empty space at the back of nums1 array.
    So if we fill the array in reverse order we never lose values we still need
    And we can avoid needing to create a second temporary array like in the initial solution

    time: O(m+n)
    memory: O(1)
     * */

    fun merge(
        nums1: IntArray,
        m: Int,
        nums2: IntArray,
        n: Int,
    ) {
        var i = m - 1
        var j = n - 1
        var k = nums1.size - 1

        while (i >= 0 && j >= 0 && k >= 0) {
            nums1[k--] = if (nums1[i] >= nums2[j]) nums1[i--] else nums2[j--]
        }

        while (i >= 0) {
            nums1[k--] = nums1[i--]
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--]
        }
    }
}
