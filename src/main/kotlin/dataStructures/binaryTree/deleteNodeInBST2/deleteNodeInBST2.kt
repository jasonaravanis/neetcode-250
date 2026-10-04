package dataStructures.binaryTree.deleteNodeInBST2

import dataStructures.binaryTree.TreeNode

// time: O(h) where h is height of BST, log(n) balanced, n worst case
// space: O(h) for recursive stack

fun deleteNodeInBST2(
    root: TreeNode?,
    key: Int,
): TreeNode? {
    if (root == null) return null

    when {
        key < root.`val` -> {
            root.left = deleteNodeInBST2(root.left, key)
        }

        key > root.`val` -> {
            root.right = deleteNodeInBST2(root.right, key)
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
                    var successor: TreeNode = right
                    while (true) {
                        val next = successor.left ?: break
                        successor = next
                    }
                    root.`val` = successor.`val`
                    root.right = deleteNodeInBST2(root.right, successor.`val`)
                }
            }
        }
    }

    return root
}

// time: O(h) where h is height of BST, log(n) balanced, n worst case
// space: O(1)

fun deleteNodeInBSTIterative(
    root: TreeNode?,
    key: Int,
): TreeNode? {
    var parent: TreeNode? = null
    var current = root

    while (current != null && current.`val` != key) {
        when {
            key < current.`val` -> {
                parent = current
                current = current.left
            }

            else -> {
                parent = current
                current = current.right
            }
        }
    }

    if (current == null) return root

    val left = current.left
    val right = current.right

    if (left == null || right == null) {
        val child = left ?: right

        when {
            parent == null -> return child
            parent.left === current -> parent.left = child
            parent.right === current -> parent.right = child
        }

        return root
    }

    var successorParent: TreeNode = current
    var successor: TreeNode = right

    while (true) {
        val next = successor.left ?: break
        successorParent = successor
        successor = next
    }

    current.`val` = successor.`val`

    if (successorParent.left === successor) {
        successorParent.left = successor.right
    } else {
        successorParent.right = successor.right
    }

    return root
}
