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

fun deleteNodeInBSTIterative(
    root: TreeNode?,
    key: Int,
): TreeNode? {
    // 1. Find the target node to be deleted and its parent
    var parent: TreeNode? = null
    var target = root
    while (target != null && target.`val` != key) {
        parent = target
        target = if (key < target.`val`) target.left else target.right
    }
    if (target == null) return root // key not present

    val left = target.left
    val right = target.right

    // 2. At most one child of target
    if (left == null || right == null) {
        val child = left ?: right
        when {
            // deleting the root
            parent == null -> return child

            parent.left === target -> parent.left = child

            else -> parent.right = child
        }
        return root
    }

    // 3. Two children: find in-order successor (leftmost of right subtree)
    var successorParent: TreeNode = target
    var successor: TreeNode = right

    while (true) {
        val next = successor.left ?: break
        successorParent = successor
        successor = next
    }

    target.`val` = successor.`val`
    if (successorParent.left === successor) {
        successorParent.left = successor.right
    } else {
        successorParent.right = successor.right
    }
    return root
}
