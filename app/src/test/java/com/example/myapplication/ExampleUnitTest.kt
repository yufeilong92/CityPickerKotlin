package com.example.myapplication

import org.junit.Test

import org.junit.Assert.*
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun text() {
        File("a.txt").readLines().forEach(::println)

    }

    @Test
    fun texts() {
        var a = if (1 > 2) {
            2
        } else {
            1
        }
        println(a)
    }

    @Test
    fun textss() {
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
        val single1 = list.any { it == 10 }
        println(single1)
        val mun = list.reduce { acc, i -> acc + i }
        println(mun)
        val strLists = listOf("a", "b", "c")
        val str = strLists.reduce { acc, s -> acc + s }
        println(str)
        list.forEachIndexed { index, i ->
//            println("$index==$i")
        }
        val take = list.take(3)
//       println("${take.toString()}")

        val takeWhile = list.takeWhile { it == 0 }
//          println("${takeWhile.toString()}")

        val filter = list.filter { it % 2 == 0 }
         println("$filter")

    }



}
