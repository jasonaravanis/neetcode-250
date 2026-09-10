package problems.algorithmsAndDataStructuresForBeginners.numberOfStudentsUnableToEatLunch

class OptimalSolution {
    /*
     * Time complexity: O(n)
     * Memory complexity: O(1)
     *
     * Key insight: the order of the students doesn't matter because we will try every student to match a sandwich
     * All that matters is the quantity of student0 and student1
     * */
    fun countStudents(
        students: IntArray,
        sandwiches: IntArray,
    ): Int {
        var result = students.size

        val count = IntArray(2)

        for (student in students) {
            count[student]++
        }

        for (s in sandwiches) {
            if (count[s] > 0) {
                count[s]--
                result--
            } else {
                break
            }
        }
        return result
    }
}
