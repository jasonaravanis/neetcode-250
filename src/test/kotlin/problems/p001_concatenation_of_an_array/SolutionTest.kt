package problems.p001_concatenation_of_an_array

import kotlin.test.Test
import kotlin.test.assertContentEquals

class SolutionTest {

    private val solution = Solution()

    @Test
    fun `example 1`() {
        assertContentEquals(
            intArrayOf(1, 4, 1, 2, 1, 4, 1, 2),
            solution.getConcatenation(intArrayOf(1, 4, 1, 2))
        )
    }

    @Test
    fun `example 2`() {
        assertContentEquals(
            intArrayOf(22, 21, 20, 1, 22, 21, 20, 1),
            solution.getConcatenation(intArrayOf(22, 21, 20, 1))
        )
    }

    @Test
    fun `single element`() {
        assertContentEquals(
            intArrayOf(0, 0),
            solution.getConcatenation(intArrayOf(0))
        )
    }

    @Test
    fun `empty array`() {
        assertContentEquals(
            intArrayOf(),
            solution.getConcatenation(intArrayOf())
        )
    }
}
