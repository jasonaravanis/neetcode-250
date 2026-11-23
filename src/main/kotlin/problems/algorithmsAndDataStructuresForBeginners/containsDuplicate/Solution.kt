package problems.algorithmsAndDataStructuresForBeginners.containsDuplicate

class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val hashSet = HashSet<Int>()
        nums.forEach {
            if (hashSet.contains(it)) {
                return true
            } else {
                hashSet.add(it)
            }
        }
        return false
    }
}
