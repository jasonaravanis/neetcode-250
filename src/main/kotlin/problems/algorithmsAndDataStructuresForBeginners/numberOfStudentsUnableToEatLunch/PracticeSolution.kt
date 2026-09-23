package problems.algorithmsAndDataStructuresForBeginners.numberOfStudentsUnableToEatLunch

class PracticeSolution {
    /*

    INITIAL
     * convert student intArray to a queue
     *
     * keep track of students queue size
     *
     * for sandwich[i] loop over each student
     *
     * if student[j] doesnt match sandwich[i], send student[j] to back of queue
     *
     * if does match, pop both
     *
     * keep track of students tried during loop. if students tried = student queue size we have tried every student
     * and the number of students remaining is the answer
     *
     * if there is no students remaining, return 0
     * time: O(i * j) because trying every student for every sandwich
     * space: O(i) for the queue for students

     OPTIMAL
     * The order of students doesn't matter, because we will try every student for each sandwich
     * all that matters is the count of each type of student relative to the current sandwich
     * time: O(i)
     * space: O(1)
     * */

    fun countStudents(
        sandwiches: IntArray,
        students: IntArray,
    ): Int {
        var students0 = students.count { it == 0 }
        var students1 = students.count { it == 1 }

        for (sandwich in sandwiches) {
            if (sandwich == 0) {
                if (students0 > 0) students0-- else break
            } else {
                if (students1 > 0) students1-- else break
            }
        }

        return students0 + students1
    }
}
