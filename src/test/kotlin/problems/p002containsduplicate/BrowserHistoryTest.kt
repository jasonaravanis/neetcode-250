package problems.p002containsduplicate

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BrowserHistoryTest {
    private val solution = Solution()

    @Test
    fun `example 1`() {
        assertTrue(solution.hasDuplicate(intArrayOf(1, 2, 3, 3)))
    }

    @Test
    fun `example 2`() {
        assertFalse(solution.hasDuplicate(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun `example 3`() {
        assertTrue(solution.hasDuplicate(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)))
    }

    @Test
    fun `single element`() {
        assertFalse(solution.hasDuplicate(intArrayOf(1)))
    }

    @Test
    fun `empty array`() {
        assertFalse(solution.hasDuplicate(intArrayOf()))
    }
}
