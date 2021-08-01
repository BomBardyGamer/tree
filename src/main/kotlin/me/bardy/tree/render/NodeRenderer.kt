package me.bardy.tree.render

import me.bardy.tree.node.Node

interface NodeRenderer<T> {

    fun render(node: Node<T>): T
}
