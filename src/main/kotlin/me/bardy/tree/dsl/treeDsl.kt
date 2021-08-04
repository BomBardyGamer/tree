package me.bardy.tree.dsl

import me.bardy.tree.BasicTree
import me.bardy.tree.SwingTree

@DslMarker
annotation class TreeDsl

@TreeDsl
inline fun basicTree(
    title: String,
    builder: BasicTree.Builder.() -> Unit
) = BasicTree.builder(title).apply(builder).build()

@TreeDsl
inline fun swingTree(
    title: String,
    builder: SwingTree.Builder.() -> Unit
) = SwingTree.builder(title).apply(builder).build()
