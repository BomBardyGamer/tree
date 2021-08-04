package me.bardy.tree.node

abstract class AbstractNode<T>(
    override val title: String,
    override val children: Collection<Node<T>>
) : Node<T>, Collection<Node<T>> by children {

    constructor(title: String, vararg children: Node<T>) : this(title, children.toList())

    abstract class Builder<B : Builder<B, T>, T>(protected val title: String) : Node.Builder<B, T> {

        protected val children = mutableListOf<Node<T>>()

        @Suppress("UNCHECKED_CAST")
        override fun node(node: Node<T>) = apply { children.add(node) } as B
    }
}
