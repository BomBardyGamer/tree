package me.bardy.tree.node

abstract class AbstractNode<T>(
    override val name: T,
    override val children: Collection<Node<T>>
) : Node<T>, Collection<Node<T>> by children {

    constructor(title: T, vararg children: Node<T>) : this(title, children.toList())

    abstract class Builder<B : Builder<B, T>, T>(protected val title: T) : Node.Builder<B, T> {

        protected val children = mutableListOf<Node<T>>()

        @Suppress("UNCHECKED_CAST")
        override fun node(node: Node<T>) = apply { children.add(node) } as B
    }
}
