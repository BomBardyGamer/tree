package me.bardy.tree

import me.bardy.tree.dsl.basicTree
import kotlin.test.Test

class TreeTest {

    @Test
    fun test() {
        val tree = basicTree("test1") {
            node("testSub1") {
                node("testSubSub1")
                node("testSubSub2") {
                    node("testSubSubSub1")
                    node("testSubSubSub2")
                    node("testSubSubSub3")
                }
                node("testSubSub3")
                node("testSubSub4")
            }
            node("testSub2")
            node("testSub3")
        }
        println(tree.render())
    }
}
