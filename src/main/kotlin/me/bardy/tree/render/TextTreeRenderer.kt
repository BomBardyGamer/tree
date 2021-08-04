package me.bardy.tree.render

import me.bardy.tree.Tree
import me.bardy.tree.node.Node

object TextTreeRenderer : TreeRenderer<String, String>, NodeRenderer<String> {

    override fun render(tree: Tree<String, String>) = buildString {
        append(tree.title).append("\n")
        append(renderNode(tree.root))
    }

    override fun render(node: Node<String>) = renderNode(node)

    private fun renderNode(node: Node<String>, prefix: String = ""): String = buildString {
        node.children.forEachIndexed { index, node1 ->
            append(prefix)
            if (index == node.children.size - 1) {
                append("└── ${node1.title}").append("\n")
                if (node1.children.isNotEmpty()) append(renderNode(node1, "$prefix    "))
            } else {
                append("├── ${node1.title}").append("\n")
                if (node1.children.isNotEmpty()) append(renderNode(node1, "$prefix│   "))
            }
        }
    }
}
