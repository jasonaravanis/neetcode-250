package problems.algorithmsAndDataStructuresForBeginners.searchA2DMatrix

/*
matrix = array of rows
m = number of rows, n = number of columns
for row r: r[i] <= r[j] where i < j

r1[n - 1] < r2[0]

time: O(m * n) to make a single ascending row

Binary search on that row is O(log(m * n))

There is a more efficient way, instead of manually making a
single big row, I need to way convert an index in that imaginary row to a [row,column] lookup in the given matrix

assuming m = 3 and n = 4
i = 0 -> [0, 0]
i = 1 -> [0, 1]
i = 2 -> [0, 2]
*/

class Solution {
    fun searchMatrix(
        matrix: Array<IntArray>,
        target: Int,
    ): Boolean {
        if (matrix.isEmpty() || matrix[0].isEmpty()) return false

        val m = matrix.size
        val n = matrix[0].size

        var l = 0
        var r = (m * n) - 1

        while (l <= r) {
            val i = (l + r) / 2
            var a = i / n
            var b = i % n
            val middleValue = matrix[a][b]

            when {
                middleValue == target -> return true
                middleValue < target -> l = i + 1
                middleValue > target -> r = i - 1
            }
        }

        return false
    }
}
