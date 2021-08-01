## Tree

A simple tree creation, rendering, parsing, and traversing library.

----

### Usage

Tree is designed around simplicity of use, so it should be fairly easy to get
the hang of.

Every tree has a root node, which is the root of the hierarchy of that tree.
This also means that every tree is in itself also a node.

Every node has a name and a list of children, meaning nodes are recursive.

Both types also have a generic type, which is what the type of the name is.
For basic trees, this type is `String`, as basic trees are made up of string
named nodes.

Example using the tree DSL:
```kotlin
val tree = basicTree("Name") {
    node("I am a child of the tree") {
        node("I am a child of the node above me")
    }
    node("I am also a child of the tree")
}
```

Or, if you prefer using the builder pattern over the DSL:
```kotlin
val tree = BasicTree.builder("Name")
    .node(BasicNode.builder("I am a child of the tree")
        .node(BasicNode("I am a child of the node above me"))
        .build())
    .node(BasicNode("I am also a child of the tree"))
    .build()
```
