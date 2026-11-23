package problems.algorithmsAndDataStructuresForBeginners.combinationSum

import kotlin.test.Test
import kotlin.test.assertEquals

class KthLargestTest {
    private val solution = Solution()

    private fun normalize(combinations: List<List<Int>>): List<List<Int>> =
        combinations
            .map { it.sorted() }
            .sortedWith(compareBy({ it.size }, { it.joinToString(",") }))

    @Test
    fun `example 1`() {
        val expected =
            normalize(
                listOf(
                    listOf(2, 2, 5),
                    listOf(9),
                ),
            )
        val actual = normalize(solution.combinationSum(intArrayOf(2, 5, 6, 9), 9))
        assertEquals(expected, actual)
    }
}
