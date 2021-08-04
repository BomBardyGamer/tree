package me.bardy.tree.render

import javax.swing.JTree
import javax.swing.tree.DefaultMutableTreeNode
import javax.swing.tree.MutableTreeNode
import javax.swing.tree.TreeNode
import me.bardy.tree.Tree
import me.bardy.tree.node.Node

object SwingTreeRenderer : TreeRenderer<JTree, TreeNode>, NodeRenderer<TreeNode> {

    override fun render(tree: Tree<JTree, TreeNode>): JTree {
        val root = render(tree.root)
        return JTree(root)
    }

    override fun render(node: Node<TreeNode>): MutableTreeNode = DefaultMutableTreeNode(node.title).apply {
        node.children.forEach { add(render(it)) }
    }
}
