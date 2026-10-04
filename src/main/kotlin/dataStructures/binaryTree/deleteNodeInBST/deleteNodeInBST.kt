package dataStructures.binaryTree.deleteNodeInBST

import dataStructures.binaryTree.TreeNode

private fun getMinNode(root: TreeNode): TreeNode {
    var current = root
    var next = current.left
    while (next != null) {
        current = next
        next = current.left
    }
    return current
}

// time: O(h) where h is the height of the binary tree
// space: O(h) where h is the height of the binary tree

fun deleteNodeInBST(
    root: TreeNode?,
    key: Int,
): TreeNode? {
    if (root == null) return null

    when {
        key < root.`val` -> {
            root.left = deleteNodeInBST(root.left, key)
        }

        key > root.`val` -> {
            root.right = deleteNodeInBST(root.right, key)
        }

        else -> {
            val left = root.left
            val right = root.right

            when {
                left == null -> {
                    return right
                }

                right == null -> {
                    return left
                }

                else -> {
                    val minNode = getMinNode(right)
                    root.`val` = minNode.`val`
                    root.right = deleteNodeInBST(root.right, minNode.`val`)
                }
            }
        }
    }
    return root
}
