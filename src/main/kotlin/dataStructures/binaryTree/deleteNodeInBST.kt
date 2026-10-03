package dataStructures.binaryTree

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

fun minValueNode(node: TreeNode): TreeNode {
    var current = node
    var next = current.left
    while (next != null) {
        current = next
        next = current.left
    }
    return current
}

fun deleteNode(
    root: TreeNode?,
    key: Int,
): TreeNode? {
    if (root == null) return null

    when {
        key < root.`val` -> root.left = deleteNode(root.left, key)
        key > root.`val` -> root.right = deleteNode(root.right, key)
        else -> {
            val left = root.left
            val right = root.right

            when {
                left == null -> return right
                right == null -> return left
                else -> {
                    val successor = minValueNode(right)
                    root.`val` = successor.`val`
                    root.right = deleteNode(right, successor.`val`)
                }
            }
        }
    }

    return root
}
