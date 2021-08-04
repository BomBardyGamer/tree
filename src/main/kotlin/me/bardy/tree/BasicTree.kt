package me.bardy.tree

import me.bardy.tree.node.BasicNode
import me.bardy.tree.node.Node
import me.bardy.tree.render.TextTreeRenderer

class BasicTree(root: Node<String>) : AbstractTree<String, String>(root) {

    override fun render() = TextTreeRenderer.render(this)

    class Builder(title: String) : AbstractTree.Builder<Builder, BasicNode.Builder, String, String>(title) {

        override fun node(title: String, builder: BasicNode.Builder.() -> Unit) = apply {
            nodes.add(BasicNode.Builder(title).apply(builder).build())
        }

        override fun build() = BasicTree(BasicNode(title, nodes))
    }

    companion object {

        @JvmStatic
        fun builder(title: String) = Builder(title)
    }
}
