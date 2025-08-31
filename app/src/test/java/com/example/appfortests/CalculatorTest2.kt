package com.example.appfortests

import org.junit.Test
import org.junit.Assert.*

class CalculatorTest2 {

    private val calculator = Calculator()

    @Test
    fun testAdd() {
        val result = calculator.add(2.0, 3.0)
        assertEquals(5.0, result, 0.0)
    }

    @Test
    fun testSubtract() {
        val result = calculator.subtract(5.0, 2.0)
        assertEquals(3.0, result, 0.0)
    }

    @Test
    fun testMultiply() {
        val result = calculator.multiply(2.0, 3.0)
        assertEquals(6.0, result, 0.0)
    }

    @Test
    fun testDivide() {
        val result = calculator.divide(6.0, 2.0)
        assertEquals(3.0, result, 0.0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testDivideByZero() {
        calculator.divide(5.0, 0.0)
    }

    @Test
    fun testPower() {
        val result = calculator.power(2.0, 3.0)
        assertEquals(8.0, result, 0.0)
    }

    @Test
    fun testSquareRoot() {
        val result = calculator.squareRoot(9.0)
        assertEquals(3.0, result, 0.0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testSquareRootNegative() {
        calculator.squareRoot(-1.0)
    }
}