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
        var a = 1
        do {
            a++
        } while (a < 20)
        println(a)
    }

    @Test
    fun textss() {
        val kNumber = getKNumber(4, 1052,100)
        println(kNumber)
    }

    fun getKNumber(k: Int, num: Int,number:Int): Int {
        //如果k越界，则返回-1
        return if (Math.pow(10.0, k - 1.toDouble()) > num) {
            -1
        } else {
            num / Math.pow(10.0, k - 1.toDouble()).toInt() % number
        }
    }
}
