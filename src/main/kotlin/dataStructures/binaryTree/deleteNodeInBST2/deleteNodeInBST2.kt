package dataStructures.binaryTree.deleteNodeInBST2

import dataStructures.binaryTree.TreeNode

// time: O(h) where h is the height of the binary search tree
// space: O(1)

fun deleteNodeInBST2(
    root: TreeNode?,
    key: Int,
): TreeNode? {
    var parent: TreeNode? = null
    var target = root

    while (target != null && target.`val` != key) {
        when {
            key < target.`val` -> {
                parent = target
                target = target.left
            }

            else -> {
                parent = target
                target = target.right
            }
        }
    }

    if (target == null) return root

    val left = target.left
    val right = target.right

    if (left == null || right == null) {
        val child = left ?: right
        when {
            parent == null -> return child
            target === parent.left -> parent.left = child
            target === parent.right -> parent.right = child
        }
        return root
    }

    var successorParent: TreeNode = target
    var successor: TreeNode = right

    while (true) {
        val next = successor.left ?: break
        successorParent = successor
        successor = next
    }

    target.`val` = successor.`val`

    when {
        successorParent.left === successor -> successorParent.left = successor.right
        else -> successorParent.right = successor.right
    }

    return root
}
