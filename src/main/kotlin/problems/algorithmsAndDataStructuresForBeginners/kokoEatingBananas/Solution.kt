package problems.algorithmsAndDataStructuresForBeginners.kokoEatingBananas

import kotlin.math.ceil

/*
* h must be >= length(piles) because imagine we set k (the bananas per hour) to be infinite, if we have five piles
* and h is 4 (four hours), it means that even though koko can eat infinite hours per hour, she is limited to one pile
* per hour, so she can only eat 4 of the five piles
*
* So we know h >= length(piles). The minimum value h can be is length(piles).
*
* The possible values of k are 1 to the maximum value in piles. Because if we set k to max, then every pile is eaten
* in one hour and the total hours is length(piles), which we said above is the minimum value of h. Note that if h was
* larger than length(piles) then a higher maximum k would be possible, but that doesn't matter because we are looking
* for the minimum k value.
*
* So we setup our binary search for minimal k in the range 1..max(piles).
*
* time complexity: O(n) to find max(piles) where n is piles.length
*   O(log(max(piles)) * n) to find minimal k -> Because we try log(max(piles) different possible k values, and for each
*  try we need to loop over every piles element to get the number of total hours taken
*
* space complexity: O(1)
*
*
* Remember to use Long instead of Int to handle large values
*
* */

class Solution {
    fun minEatingSpeed(
        piles: IntArray,
        h: Int,
    ): Int {
        var l = 1
        var r = piles.max()
        var response = r

        while (l <= r) {
            val k = l + (r - l) / 2
            val time = piles.sumOf { ceil(it.toDouble() / k).toLong() }
            if (time <= h) {
                response = k
                r = k - 1
            } else {
                l = k + 1
            }
        }

        return response
    }
}
