package problems.algorithmsAndDataStructuresForBeginners.kokoEatingBananas

import kotlin.math.ceil

/*
we are looking for minimum k
if k is too small, total hours taken > h
if k big enough but not minimal, total hours taken < h

we are looking for the minimum k where hours taken <= h

we are told that h >= piles.length. It must be, because if h < piles.length even with k set to infinity koko could never get through all the piles because she is limited to one pile per hour

if h > piles.length it doesn't matter for minimising k. If we minimise k at h == piles.length then that k will still be the minimum at any h > piles.length

minimum possible k: 1 -> if 0 then total hours taken is infinite
maximum possible k: maxOf(piles) -> would mean total hours taken == h. Anything beyond maxOf(piles) would lead to the same total hours taken

so find minimum k in range 1..maxOf(piles)

time: O(piles.length * log(piles.max))
space: O(1)

*/

class Solution2 {
    fun minEatingSpeed(
        piles: IntArray,
        h: Int,
    ): Int {
        var l = 1
        var r = piles.max()
        var answer = r

        while (l <= r) {
            val k = l + (r - l) / 2
            val timeTaken = piles.sumOf { ceil(it.toDouble() / k).toInt() }
            if (timeTaken > h) {
                l = k + 1
            }
            if (timeTaken <= h) {
                r = k - 1
                answer = minOf(answer, k)
            }
        }

        return answer
    }
}
