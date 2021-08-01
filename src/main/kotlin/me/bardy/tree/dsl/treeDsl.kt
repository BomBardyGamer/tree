package me.bardy.tree.dsl

import me.bardy.tree.BasicTree

@DslMarker
annotation class TreeDsl

@TreeDsl
inline fun basicTree(
    title: String,
    builder: BasicTree.Builder.() -> Unit
) = BasicTree.Builder(title).apply(builder).build()
