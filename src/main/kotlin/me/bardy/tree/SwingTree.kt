package me.bardy.tree

import javax.swing.JTree
import javax.swing.tree.TreeNode
import me.bardy.tree.node.Node
import me.bardy.tree.node.SwingNode
import me.bardy.tree.render.SwingTreeRenderer

class SwingTree(root: Node<TreeNode>) : AbstractTree<JTree, TreeNode>(root) {

    override fun render() = SwingTreeRenderer.render(this)

    class Builder(title: String) : AbstractTree.Builder<Builder, SwingNode.Builder, JTree, TreeNode>(title) {

        override fun node(title: String, builder: SwingNode.Builder.() -> Unit) = apply {
            nodes.add(SwingNode.Builder(title).apply(builder).build())
        }

        override fun build() = SwingTree(SwingNode(title, nodes))
    }

    companion object {

        @JvmStatic
        fun builder(title: String) = Builder(title)
    }
}
