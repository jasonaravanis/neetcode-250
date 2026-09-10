package problems.algorithmsAndDataStructuresForBeginners.numberOfStudentsUnableToEatLunch

class InitialSolution {
    enum class Sandwich(
        val value: Int,
    ) {
        CIRCLE(0),
        SQUARE(1),
        ;

        companion object {
            fun fromValue(value: Int): Sandwich =
                when (value) {
                    0 -> CIRCLE
                    1 -> SQUARE
                    else -> error("Unknown sandwich value: $value")
                }
        }
    }

    private data class Node(
        val sandwich: Sandwich,
        var next: Node? = null,
    )

    fun countStudents(
        students: IntArray,
        sandwiches: IntArray,
    ): Int {
        /*
         * convert each array into a queue using linked lists
         *
         * for student i=0 try sandwiches j=0
         *
         * if successful, deque both
         * if not successful, deque student and enque student
         *
         * terminal condition: if every student has attempted to take sandwich j and they've all refused, then that's the final answer
         *
         * so need to keep track of number of students remaining and number of students trialled until a match is made
         * */

        var studentQueueHead: Node? = null
        var studentQueueTail: Node? = null
        var studentsRemaining: Int = 0

        for ((index, student) in students.withIndex()) {
            studentsRemaining++
            val node = Node(sandwich = Sandwich.fromValue(student))
            if (index == 0) {
                studentQueueHead = node
                studentQueueTail = node
                continue
            }
            studentQueueTail?.next = node
            studentQueueTail = node
        }

        var sandwichQueueHead: Node? = null
        var sandwichQueueTail: Node? = null

        for ((index, sandwich) in sandwiches.withIndex()) {
            val node = Node(sandwich = Sandwich.fromValue(sandwich))
            if (index == 0) {
                sandwichQueueHead = node
                sandwichQueueTail = node
                continue
            }
            sandwichQueueTail?.next = node
            sandwichQueueTail = node
        }

        var studentsTried = 0

        while (studentsRemaining > 0 && studentsTried != studentsRemaining) {
            if (studentQueueHead?.sandwich == sandwichQueueHead?.sandwich) {
                studentQueueHead = studentQueueHead?.next
                sandwichQueueHead = sandwichQueueHead?.next
                studentsTried = 0
                studentsRemaining--
            } else {
                val node = studentQueueHead
                studentQueueHead = studentQueueHead?.next
                studentQueueTail?.next = node
                studentQueueTail = node
                studentQueueTail?.next = null
                studentsTried++
            }
        }

        return studentsRemaining
    }
}
