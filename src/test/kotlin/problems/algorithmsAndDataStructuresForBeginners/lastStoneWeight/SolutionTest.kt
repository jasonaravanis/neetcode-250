package problems.algorithmsAndDataStructuresForBeginners.lastStoneWeight

import kotlin.test.Test
import kotlin.test.assertEquals

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `example 1`() {
        assertEquals(1, solution.lastStoneWeight(intArrayOf(2, 3, 6, 2, 4)))
    }

    @Test
    fun `single stone is returned as is`() {
        assertEquals(7, solution.lastStoneWeight(intArrayOf(7)))
    }

    @Test
    fun `all stones cancel out`() {
        assertEquals(0, solution.lastStoneWeight(intArrayOf(1, 1)))
    }

    @Test
    fun `repeated equal stones leave nothing`() {
        assertEquals(0, solution.lastStoneWeight(intArrayOf(2, 2, 2, 2)))
    }

    @Test
    fun `emptiness returns zero`() {
        assertEquals(0, solution.lastStoneWeight(intArrayOf()))
    }
}
