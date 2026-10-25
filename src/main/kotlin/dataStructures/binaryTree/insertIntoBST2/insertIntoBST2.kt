package dataStructures.binaryTree.insertIntoBST2

import dataStructures.binaryTree.TreeNode
import dataStructures.binaryTree.insertIntoBST.insertIntoBSTRecursive

// time: O(h) where h is the height of the BST, O(log(n)) average or O(n) worst
// space: O(h) where h is the height of the BST, O(log(n)) average or O(n) worst

fun insertIntoBST2Recursive(
    root: TreeNode?,
    key: Int,
): TreeNode {
    if (root == null) return TreeNode(key)

    when {
        key < root.`val` -> {
            root.left = insertIntoBST2Recursive(root.left, key)
        }

        key > root.`val` -> {
            root.right = insertIntoBST2Recursive(root.right, key)
        }

        else -> {
            return root
        }
    }
    return root
}

// time: O(h) where h is the height of the BST, log(n) average n worst
// space: O(1)

fun insertIntoBST2Iterative(
    root: TreeNode?,
    key: Int,
): TreeNode {
    val node = TreeNode(key)

    if (root == null) return node

    var current: TreeNode = root

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
