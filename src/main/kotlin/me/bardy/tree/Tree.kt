package me.bardy.tree

import me.bardy.tree.node.Node

interface Tree<T> : Node<T>, Collection<Node<T>> {

    val root: Node<T>

    fun render(): T

    interface Builder<B : Builder<B, N, T>, N : Node.Builder<N, T>, T> {

        fun node(node: Node<T>): B

        @JvmSynthetic
        fun node(title: T, builder: N.() -> Unit = {}): B

        fun build(): Tree<T>
    }
}
