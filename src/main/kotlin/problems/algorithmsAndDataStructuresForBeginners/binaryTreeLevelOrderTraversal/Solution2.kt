package problems.algorithmsAndDataStructuresForBeginners.binaryTreeLevelOrderTraversal

import dataStructures.binaryTree.TreeNode

// time: O(n)
// space: O(n) from the queue, the answer, and the sublist all scaling with n

class Solution2 {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val answer = mutableListOf<List<Int>>()
        if (root == null) return answer
        val queue = ArrayDeque<TreeNode>()

        queue.add(root)

        while (!queue.isEmpty()) {
            val sublist = mutableListOf<Int>()
            for (i in queue.indices) {
                val node = queue.removeFirst()
                sublist.add(node.`val`)
                val left = node.left
                val right = node.right
                if (left != null) {
                    queue.addLast(left)
                }
                if (right != null) {
                    queue.addLast(right)
                }
            }
            answer.add(sublist)
        }
        return answer
    }
}
