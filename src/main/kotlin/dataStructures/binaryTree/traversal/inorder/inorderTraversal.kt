package dataStructures.binaryTree.traversal.inorder

import dataStructures.binaryTree.TreeNode

fun inorderTraversal(root: TreeNode?): List<Int> {
    val mutableList = mutableListOf<Int>()

    fun recurse(r: TreeNode?) {
        if (r == null) return
        recurse(r.left)
        mutableList.add(r.`val`)
        recurse(r.right)
    }

    recurse(root)

    return mutableList.toList()
}
