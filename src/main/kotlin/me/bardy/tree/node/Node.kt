package me.bardy.tree.node

interface Node<T> : Collection<Node<T>> {

    val name: T

    val children: Collection<Node<T>>

    interface Builder<B : Builder<B, T>, T> {

        fun node(node: Node<T>): B

        fun node(title: T, builder: B.() -> Unit = {}): B

        fun build(): Node<T>
    }
}
