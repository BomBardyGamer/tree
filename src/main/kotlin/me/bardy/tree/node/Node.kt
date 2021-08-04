package me.bardy.tree.node

interface Node<T> : Collection<Node<T>> {

    val title: String

    val children: Collection<Node<T>>

    interface Builder<B : Builder<B, T>, T> {

        fun node(node: Node<T>): B

        fun node(title: String, builder: B.() -> Unit = {}): B

        fun build(): Node<T>
    }
}
