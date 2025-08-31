package com.example.appfortests

import org.junit.Test
import org.junit.Assert.*
import kotlin.math.pow
import kotlin.math.sqrt

class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun `add should return correct sum`() {
        assertEquals(5.0, calculator.add(2.0, 3.0), 0.001)
        assertEquals(-1.0, calculator.add(2.0, -3.0), 0.001)
        assertEquals(0.0, calculator.add(-2.0, 2.0), 0.001)
    }

    @Test
    fun `subtract should return correct difference`() {
        assertEquals(2.0, calculator.subtract(5.0, 3.0), 0.001)
        assertEquals(5.0, calculator.subtract(2.0, -3.0), 0.001)
        assertEquals(-4.0, calculator.subtract(-2.0, 2.0), 0.001)
    }

    @Test
    fun `multiply should return correct product`() {
        assertEquals(6.0, calculator.multiply(2.0, 3.0), 0.001)
        assertEquals(-6.0, calculator.multiply(2.0, -3.0), 0.001)
        assertEquals(4.0, calculator.multiply(-2.0, -2.0), 0.001)
        assertEquals(0.0, calculator.multiply(0.0, 5.0), 0.001)
    }

    @Test
    fun `divide should return correct quotient`() {
        assertEquals(2.0, calculator.divide(6.0, 3.0), 0.001)
        assertEquals(-2.0, calculator.divide(6.0, -3.0), 0.001)
        assertEquals(2.5, calculator.divide(-5.0, -2.0), 0.001)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `divide should throw exception when dividing by zero`() {
        calculator.divide(5.0, 0.0)
    }

    @Test
    fun `power should return correct result`() {
        assertEquals(8.0, calculator.power(2.0, 3.0), 0.001)
        assertEquals(1.0, calculator.power(5.0, 0.0), 0.001)
        assertEquals(0.25, calculator.power(2.0, -2.0), 0.001)
        assertEquals(9.0, calculator.power(-3.0, 2.0), 0.001)
    }

    @Test
    fun `squareRoot should return correct result`() {
        assertEquals(3.0, calculator.squareRoot(9.0), 0.001)
        assertEquals(0.0, calculator.squareRoot(0.0), 0.001)
        assertEquals(2.0, calculator.squareRoot(4.0), 0.001)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `squareRoot should throw exception when value is negative`() {
        calculator.squareRoot(-4.0)
    }
}