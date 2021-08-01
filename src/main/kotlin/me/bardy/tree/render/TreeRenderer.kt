package me.bardy.tree.render

import me.bardy.tree.Tree

interface TreeRenderer<T> {

    fun render(tree: Tree<T>): T
}
