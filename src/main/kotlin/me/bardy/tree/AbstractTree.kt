package me.bardy.tree

import me.bardy.tree.node.Node

abstract class AbstractTree<T>(override val root: Node<T>) : Tree<T>, Node<T> by root {

    abstract class Builder<B : Builder<B, N, T>, N : Node.Builder<N, T>, T>(protected val title: String) : Tree.Builder<B, N, T> {

        protected val nodes = mutableListOf<Node<T>>()

        @Suppress("UNCHECKED_CAST")
        override fun node(node: Node<T>): B = apply { nodes.add(node) } as B
    }
}
