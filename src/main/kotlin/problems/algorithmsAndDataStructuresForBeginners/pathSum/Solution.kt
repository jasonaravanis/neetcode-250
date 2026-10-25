package problems.algorithmsAndDataStructuresForBeginners.pathSum

import dataStructures.binaryTree.TreeNode

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun hasPathSum(
        root: TreeNode?,
        targetSum: Int,
    ): Boolean {
        /*
        recursive brute force algorithm
        a global array that keeps track of every path node

        exit cases:
        1 - root is null
        2 - adding current node to pathTotal > targetSum
        3 - current node is a leaf node && pathTotal != targetSum

        otherwise:
        add node val to path array
        if left node && hasPathSum(node.left, targetSum) return true
        if right node && hasPathSum(node.right, targetSum) return true
        pathTotal.pop()
        return false
         */

        val path = mutableListOf<Int>()

        return hasPathSumRecurse(root, targetSum, path)
    }

    private fun hasPathSumRecurse(
        root: TreeNode?,
        targetSum: Int,
        path: MutableList<Int>,
    ): Boolean {
        if (root == null) return false

        path.add(root.`val`)

        val left = root.left
        val right = root.right

        if (left == null && right == null) {
            if (path.sum() == targetSum) {
                return true
            } else {
                path.removeLast()
                return false
            }
        }

        if (hasPathSumRecurse(root.left, targetSum, path)) {
            return true
        }
        if (hasPathSumRecurse(root.right, targetSum, path)) {
            return true
        }
        path.removeLast()
        return false
    }
}
