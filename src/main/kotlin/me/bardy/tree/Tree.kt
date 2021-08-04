package me.bardy.tree

import me.bardy.tree.node.Node

interface Tree<T, N> : Node<N>, Collection<Node<N>> {

    val root: Node<N>

    fun render(): T

    interface Builder<B : Builder<B, NB, T, N>, NB : Node.Builder<NB, N>, T, N> {

        fun node(node: Node<N>): B

        @JvmSynthetic
        fun node(title: String, builder: NB.() -> Unit = {}): B

        fun build(): Tree<T, N>
    }
}
