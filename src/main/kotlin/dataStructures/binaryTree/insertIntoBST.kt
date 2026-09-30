package dataStructures.binaryTree

class TreeNode(
    var `val`: Int,
) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class insertIntoBST {
    fun insertIntoBST(
        root: TreeNode?,
        `val`: Int,
    ): TreeNode {
        val node = TreeNode(`val`)

        if (root == null) return node

        var cur: TreeNode = root

        while (true) {
            if (`val` < cur.`val`) {
                val left = cur.left
                if (left == null) {
                    cur.left = node
                    return root
                }
                cur = left
            } else {
                val right = cur.right
                if (right == null) {
                    cur.right = node
                    return root
                }
                cur = right
            }
        }
    }

    // fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
    //     when {
    //         root == null -> return TreeNode(`val`)
    //         `val` < root.`val` -> root.left = insertIntoBST(root.left, `val`)
    //         `val` > root.`val` -> root.right = insertIntoBST(root.right, `val`)
    //         else -> return root
    //     }

    //     return root
    // }
}
