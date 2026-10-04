package dataStructures.binaryTree.insertIntoBST2

import dataStructures.binaryTree.TreeNode

// time: O(h) where h is height of binary search tree, log(n) average n worst case
// space: O(h) where h is height of binary search tree, log(n) average n worst case

fun insertIntoBST2(
    root: TreeNode?,
    key: Int,
): TreeNode {
    if (root == null) return TreeNode(key)

    when {
        key < root.`val` -> root.left = insertIntoBST2(root.left, key)
        key > root.`val` -> root.right = insertIntoBST2(root.right, key)
        else -> return root
    }

    return root
}

// time: O(h)
// space: O(1)

fun insertIntoBST2Iterative(
    root: TreeNode?,
    key: Int,
): TreeNode {
    val node = TreeNode(key)

    var current = root ?: return node

    while (true) {
        when {
            key < current.`val` -> {
                val left = current.left
                if (left == null) {
                    current.left = node
                    return root
                } else {
                    current = left
                }
            }

            key > current.`val` -> {
                val right = current.right
                if (right == null) {
                    current.right = node
                    return root
                } else {
                    current = right
                }
            }

            else -> {
                return root
            }
        }
    }
}
