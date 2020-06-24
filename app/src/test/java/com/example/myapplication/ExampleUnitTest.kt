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
    fun text(){
        File("a.txt").readLines().forEach(::println)

    }

    @Test
    fun texts(){

    }
}
