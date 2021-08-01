package me.bardy.tree.node

class BasicNode(
    title: String,
    children: Collection<Node<String>> = emptyList()
) : AbstractNode<String>(title, children) {

    class Builder(title: String) : AbstractNode.Builder<Builder, String>(title) {

        override fun node(title: String, builder: Builder.() -> Unit): Builder = apply {
            children.add(Builder(title).apply(builder).build())
        }

        override fun build() = BasicNode(title, children)
    }

    companion object {

        @JvmStatic
        fun builder(title: String) = Builder(title)
    }
}
