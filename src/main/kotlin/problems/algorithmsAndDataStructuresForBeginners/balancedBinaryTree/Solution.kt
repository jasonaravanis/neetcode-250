package problems.algorithmsAndDataStructuresForBeginners.balancedBinaryTree

import dataStructures.binaryTree.TreeNode
import kotlin.math.abs

// time: O(n)
// space: O(h) where h is the height of the tree

class Solution {
    fun isBalanced(root: TreeNode?): Boolean = getTreeHeight(root) != -1

    private fun getTreeHeight(node: TreeNode?): Int {
        if (node == null) return 0
        val leftHeight = getTreeHeight(node.left)
        if (leftHeight == -1) return -1
        val rightHeight = getTreeHeight(node.right)
        if (rightHeight == -1) return -1

        if (abs(leftHeight - rightHeight) > 1) {
            return -1
        }

        return 1 + maxOf(leftHeight, rightHeight)
    }
}
