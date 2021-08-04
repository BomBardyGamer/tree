package me.bardy.tree.node

import javax.swing.tree.TreeNode

class SwingNode(
    title: String,
    children: Collection<Node<TreeNode>>
) : AbstractNode<TreeNode>(title, children) {

    class Builder(title: String) : AbstractNode.Builder<Builder, TreeNode>(title) {

        override fun node(title: String, builder: Builder.() -> Unit) = apply {
            children.add(Builder(title).apply(builder).build())
        }

        override fun build() = SwingNode(title, children)
    }

    companion object {

        @JvmStatic
        fun builder(title: String) = Builder(title)
    }
}
