package com.example.appfortests

import org.junit.Test
import org.junit.Assert.*

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
    fun multiplication_isCorrect() {
        assertEquals(6, 2 * 3)
    }
    
    @Test
    fun stringConcatenation_isCorrect() {
        val result = "Hello" + " " + "World"
        assertEquals("Hello World", result)
    }
    
    @Test
    fun booleanLogic_isCorrect() {
        assertTrue(true && true)
        assertFalse(true && false)
        assertTrue(true || false)
    }
}