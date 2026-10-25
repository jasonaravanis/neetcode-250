package dataStructures.binaryTree.deleteNodeInBST2

import dataStructures.binaryTree.TreeNode

// time: O(h), h is height of BST, either log(n) average or n worst case
// space: O(h), h is height of BST, either log(n) average or n worst case

fun deleteNodeInBST2Recursive(
    root: TreeNode?,
    key: Int,
): TreeNode? {
    if (root == null) {
        return null
    }

    when {
        key < root.`val` -> {
            root.left = deleteNodeInBST2Recursive(root.left, key)
        }

        key > root.`val` -> {
            root.right = deleteNodeInBST2Recursive(root.right, key)
        }

        else -> {
            val left = root.left
            val right = root.right
            if (left == null || right == null) {
                val child = left ?: right
                return child
            }

            var successor: TreeNode = right
            while (true) {
                successor = successor.left ?: break
            }

            root.`val` = successor.`val`
            root.right = deleteNodeInBST2Recursive(root.right, successor.`val`)
        }
    }

    return root
}

// time: O(h), h is the height of BST, either log(n) average or n worst case
// space: O(1)

fun deleteNodeInBST2Iterative(
    root: TreeNode?,
    key: Int,
): TreeNode? {
    var parent: TreeNode? = null
    var current: TreeNode? = root

    while (current != null && current.`val` != key) {
        when {
            key < current.`val` -> {
                parent = current
                current = current.left
            }

            key > current.`val` -> {
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
            parent == null -> {
                return child
            }

            current === parent.left -> {
                parent.left = child
            }

            current === parent.right -> {
                parent.right = child
            }
        }
        return root
    }

    var successor: TreeNode = right
    var successorParent: TreeNode = current

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
