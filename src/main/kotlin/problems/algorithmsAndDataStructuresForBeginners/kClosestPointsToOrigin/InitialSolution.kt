package problems.algorithmsAndDataStructuresForBeginners.kClosestPointsToOrigin

import kotlin.math.pow
import kotlin.math.sqrt

/*

Naive Solution
* step 1. calculate the distance from the origin for each point, attach to copy of the points array. Structure: xi, yi, di
* step 2: sort the points array based on the di value of each element in ascending order
* step 3: return the first k elements of points, without the di...
*
* step 1 time: O(n) and space: O(n)
* step 2 time: O(n log(n)) and space O(log n)
* step 3 time: O(k) space O(1)

Better Solution?? Not really. Need a max heap but don't know that yet.
Make a linked list
For each point
Calculate di
Traverse linked list until either reach kth element or find spot where new node should be added
return first k elements of linked list

time: O(k*n)
space: O(n)
* */

class InitialSolution {
    private data class PointWithDistance(
        val x: Int,
        val y: Int,
        val di: Double,
    )

    private fun sort(
        arr: Array<PointWithDistance>,
        start: Int,
        end: Int,
    ) {
        if (start >= end) return

        var i = start
        var j = start

        while (j < end) {
            if (arr[j].di <= arr[end].di) {
                val temp = arr[j]
                arr[j] = arr[i]
                arr[i] = temp
                i++
            }
            j++
        }

        val temp = arr[i]
        arr[i] = arr[end]
        arr[end] = temp

        sort(arr, start, i - 1)
        sort(arr, i + 1, end)
    }

    private fun quickSortPointWithDistance(arr: Array<PointWithDistance>) {
        sort(arr, 0, arr.size - 1)
    }

    fun kClosest(
        points: Array<IntArray>,
        k: Int,
    ): Array<IntArray> {
        val pointsWithDistances: Array<PointWithDistance> =
            points
                .map { it ->
                    val xSquareDistance = it[0].toDouble().pow(2)
                    val ySquareDistance = it[1].toDouble().pow(2)
                    val di = sqrt(xSquareDistance + ySquareDistance)
                    PointWithDistance(it[0], it[1], di)
                }.toTypedArray()

        quickSortPointWithDistance(pointsWithDistances)

        return pointsWithDistances.take(k).map { intArrayOf(it.x, it.y) }.toTypedArray()
    }
}
