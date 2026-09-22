package problems.algorithmsAndDataStructuresForBeginners.mergeSortedArrays

class PracticeSolution {
    /*
     * dumb solution: overwrite the 0s with the n elements and then merge sort the entire array
     * time complexity: O(m+n * log(m+n))
     * space complexity: O(m + n) used by the temp array in the merge sort
     *
     *
     * smart solution:
     * make a new array of length n + m
     * then iterate over both lists, taking each element
     * then copy that new array back into nums1
     *
     * time: O(n + m)
     * space: O(n + m)
     *
     * smartest solution:
     * do the smart solution but fill from the back, means we don't need the extra temp array
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

        while (i >= 0 && j >= 0) {
            nums1[k--] = if (nums1[i] > nums2[j]) nums1[i--] else nums2[j--]
        }
        while (i >= 0) {
            nums1[k--] = nums1[i--]
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--]
        }
    }
}
