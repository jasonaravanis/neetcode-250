package problems.algorithmsAndDataStructuresForBeginners.binaryTreeLevelOrderTraversal

import dataStructures.binaryTree.TreeNode

// time: O(n)
// space: O(n)

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val answer = mutableListOf<List<Int>>()

        val queue = ArrayDeque<TreeNode>()

        if (root != null) {
            queue.add(root)
        }

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
            answer.addLast(sublist)
        }

        return answer
    }
}
