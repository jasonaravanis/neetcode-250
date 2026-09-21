package problems.algorithmsAndDataStructuresForBeginners.mergeKsortedLinkedLists

/*
k: number of lists
n: number of elements across all lists


* brute method: put every element from every list into an array, and sort it using merge sort
*    time: O(n * log n)
*    space: O(n)
*
* iterative method: loop over the head of each list, taking the smallest value each time and incrementing the list
*    time: O(k * n) -> because we run the loop for each N, and within the loop we need to compare to the first element
           of k lists
     space: O(1) -> no new objects created, just changing pointers on existing objects

* iterative method 2: merge each list one at a time
     time: O(k * n) -> because each time we merge a list into an accumulator, we are looping over the same elements
           over and over again
           more detail: Assume X lists of equal length Y
           merging one list at a time up to the final Xth list:
           i = 1, merge = Y + Y, cost = 2Y
           i = 2, merge = Y + 2Y, cost = 3Y
           i = 3, merge = Y + 3Y, cost = 4Y
           ...
           i = X - 1, merge = Y + Y(X - 1), cost = Y*X

           Total cost = 2Y + 3Y + 4Y ... + (X*Y)
                      = Y(2 + 3 + 4 ... + X)

           Gauss:
            Sum = 1 + 2 + 3 ... + j
            Sum = j + (j - 1) + (j - 2) + (j - 3) ... 1

            So 2*Sum = (j + 1) + (j + 1) + (j + 1) ....
            There are j elements so
            2*Sum = j(j+1)

            Or: Sum = j(j+1)/2

            So going back to total cost:
              our sum starts from 2, so subtract 1 from it
            Total cost = Y * (X(X+1)/2 - 1)

            = Y(X^2)/2) + (Y*X)/2 - Y

            The dominant term is X^2, so drop the other factors and constants

            = Y * X^2

            we know that Y = n / x

            = O(n * x)

            where n is the total number of elements across all lists and x is the number of lists

 OPTIMAL METHOD

 Merge each list with the next list, halving the number of lists each time

 time complexity:
    merge list A with list B is O(m) where m is the total number of elements across A and B
    when we merge each list with the next list, we end up going over all of the elements in the lists (this is (O(n))
    the number of times we do that depends on how many times we need to divide k by 2 to get to a single remaining list

    that is log k

    so total time complexity is O(n * log(k))

space complexity:
    each time we generate a new batch of merged lists we need to store it in a temporary variable of length N

    so space is O(n)


* */

class OptimalSolutionPractice {
    fun mergeTwoLists(
        list1: ListNode?,
        list2: ListNode?,
    ): ListNode? {
        val sentinel = ListNode(0)
        var tail = sentinel
        var i1 = list1
        var i2 = list2

        while (i1 != null && i2 != null) {
            var node: ListNode?
            if (i1.`val` <= i2.`val`) {
                node = i1
                i1 = i1.next
            } else {
                node = i2
                i2 = i2.next
            }
            tail.next = node
            tail = node
        }

        tail.next = i1 ?: i2

        return sentinel.next
    }

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null

        var store = lists.clone().toMutableList()

        while (store.size > 1) {
            val temp = mutableListOf<ListNode?>()
            for (i in store.indices step 2) {
                val list1 = store[i]
                val list2 = store.getOrNull(i + 1)
                val merged = mergeTwoLists(list1, list2)
                temp.add(merged)
            }
            store = temp
        }

        return store[0]
    }
}
