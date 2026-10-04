package dataStructures.binaryTree.insertIntoBST

import dataStructures.binaryTree.TreeNode

// time:  average O(log(n)) worst: O(n)
// space: O(1)

fun insertIntoBSTIterative(
    root: TreeNode?,
    key: Int,
): TreeNode {
    val node = TreeNode(key)

    if (root == null) return node

    var current: TreeNode = root

    while (true) {
        if (node.`val` == current.`val`) return root
        if (node.`val` < current.`val`) {
            val left = current.left
            if (left == null) {
                current.left = node
                return root
            } else {
                current = left
            }
        } else {
            val right = current.right
            if (right == null) {
                current.right = node
                return root
            } else {
                current = right
            }
        }
    }
}

// time: average: O(log(n)) worst: O(n)
// space: average: O(log(n)) worst: O(n)

fun insertIntoBSTRecursive(
    root: TreeNode?,
    key: Int,
): TreeNode {
    if (root == null) {
        return TreeNode(key)
    }

    when {
        key < root.`val` -> root.left = insertIntoBSTRecursive(root.left, key)
        key > root.`val` -> root.right = insertIntoBSTRecursive(root.right, key)
        else -> return root
    }

    return root
}
