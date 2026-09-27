package problems.algorithmsAndDataStructuresForBeginners.kClosestPointsToOrigin

class KotlinSolution {
    fun kClosest(
        points: Array<IntArray>,
        k: Int,
    ): Array<IntArray> = points.sortedBy { (x, y) -> x * x + y * y }.take(k).toTypedArray()
}
