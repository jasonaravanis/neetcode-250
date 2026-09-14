package algorithms.mergeSort

import kotlin.test.Test
import kotlin.test.assertContentEquals

class MergeSortTest {
    private val mergeSort = MergeSort()

    @Test
    fun `empty array`() {
        assertContentEquals(intArrayOf(), mergeSort.sort(intArrayOf()))
    }

    @Test
    fun `single element`() {
        assertContentEquals(intArrayOf(5), mergeSort.sort(intArrayOf(5)))
    }

    @Test
    fun `two elements sorted`() {
        assertContentEquals(intArrayOf(1, 2), mergeSort.sort(intArrayOf(1, 2)))
    }

    @Test
    fun `two elements reversed`() {
        assertContentEquals(intArrayOf(1, 2), mergeSort.sort(intArrayOf(2, 1)))
    }

    @Test
    fun `example`() {
        assertContentEquals(
            intArrayOf(1, 2, 3, 4, 5, 7, 8, 9),
            mergeSort.sort(intArrayOf(5, 2, 8, 1, 9, 3, 7, 4)),
        )
    }

    @Test
    fun `duplicates`() {
        assertContentEquals(
            intArrayOf(1, 1, 2, 2, 3, 3),
            mergeSort.sort(intArrayOf(3, 1, 2, 3, 2, 1)),
        )
    }

    @Test
    fun `already sorted`() {
        assertContentEquals(
            intArrayOf(1, 2, 3, 4, 5),
            mergeSort.sort(intArrayOf(1, 2, 3, 4, 5)),
        )
    }

    @Test
    fun `negative numbers`() {
        assertContentEquals(
            intArrayOf(-5, -3, -1, 0, 4),
            mergeSort.sort(intArrayOf(4, -1, 0, -5, -3)),
        )
    }
}
