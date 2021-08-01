package me.bardy.tree

import me.bardy.tree.node.BasicNode
import me.bardy.tree.node.Node
import me.bardy.tree.render.TextRenderer

class BasicTree(root: Node<String>) : AbstractTree<String>(root) {

    override fun render() = TextRenderer.render(this)

    class Builder(title: String) : AbstractTree.Builder<Builder, BasicNode.Builder, String>(title) {

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
