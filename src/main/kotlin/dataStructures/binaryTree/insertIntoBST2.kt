package dataStructures.binaryTree

/*
* time: O(h) where h is the height of the binary tree. For an equally balanced tree, this is log(n) where n is the
* number of items in the tree. For a completely one sided tree, this would be equivalent to a LinkedList, so O(n).
*
* space: O(h) for the recursion stack layers, where h is the height of the binary tree. For an equally balanced tree,
* this is log(n). In the worst case the tree is completely one sided, making it basically a LinkedList. In which case
* the space complexity would be O(n)
* */

fun insertIntoBST(
    root: TreeNode?,
    `val`: Int,
): TreeNode {
    val node = TreeNode(`val`)

    if (root == null) return node

    if (`val` < root.`val`) {
        root.left = insertIntoBST(root.left, `val`)
    } else {
        root.right = insertIntoBST(root.right, `val`)
    }
    return root
}

/*
* time: O(h) where h is height of the tree, which would be log(n) in best case, or n in worst case
* space: O(1) -> no recursion, just a single pointer
* */

fun insertIntoBSTIterative(
    root: TreeNode?,
    `val`: Int,
): TreeNode {
    val node = TreeNode(`val`)
    if (root == null) return node

    var current: TreeNode = root

    while (true) {
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
