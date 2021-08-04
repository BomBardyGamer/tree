package me.bardy.tree

import me.bardy.tree.node.Node

abstract class AbstractTree<T, N>(override val root: Node<N>) : Tree<T, N>, Node<N> by root {

    abstract class Builder<B : Builder<B, NB, T, N>, NB : Node.Builder<NB, N>, T, N>(protected val title: String) : Tree.Builder<B, NB, T, N> {

        protected val nodes = mutableListOf<Node<N>>()

        @Suppress("UNCHECKED_CAST")
        override fun node(node: Node<N>): B = apply { nodes.add(node) } as B
    }
}
