package me.bardy.tree.render

import me.bardy.tree.Tree

interface TreeRenderer<T, N> {

    fun render(tree: Tree<T, N>): T
}
