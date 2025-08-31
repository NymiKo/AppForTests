package com.example.appfortests

import org.junit.Test
import org.junit.Assert.*

class CalculatorTest {
    
    private val calculator = Calculator()
    
    @Test
    fun testAdd() {
        // Тест сложения положительных чисел
        assertEquals(5.0, calculator.add(2.0, 3.0), 0.001)
        
        // Тест сложения с нулем
        assertEquals(3.0, calculator.add(3.0, 0.0), 0.001)
        
        // Тест сложения отрицательных чисел
        assertEquals(-5.0, calculator.add(-2.0, -3.0), 0.001)
        
        // Тест сложения положительного и отрицательного числа
        assertEquals(1.0, calculator.add(4.0, -3.0), 0.001)
        
        // Тест сложения дробных чисел
        assertEquals(3.5, calculator.add(1.5, 2.0), 0.001)
    }
    
    @Test
    fun testSubtract() {
        // Тест вычитания положительных чисел
        assertEquals(1.0, calculator.subtract(3.0, 2.0), 0.001)
        
        // Тест вычитания нуля
        assertEquals(3.0, calculator.subtract(3.0, 0.0), 0.001)
        
        // Тест вычитания из нуля
        assertEquals(-3.0, calculator.subtract(0.0, 3.0), 0.001)
        
        // Тест вычитания отрицательных чисел
        assertEquals(1.0, calculator.subtract(-2.0, -3.0), 0.001)
        
        // Тест вычитания дробных чисел
        assertEquals(0.5, calculator.subtract(2.5, 2.0), 0.001)
    }
    
    @Test
    fun testMultiply() {
        // Тест умножения положительных чисел
        assertEquals(6.0, calculator.multiply(2.0, 3.0), 0.001)
        
        // Тест умножения на ноль
        assertEquals(0.0, calculator.multiply(5.0, 0.0), 0.001)
        
        // Тест умножения на единицу
        assertEquals(5.0, calculator.multiply(5.0, 1.0), 0.001)
        
        // Тест умножения отрицательных чисел
        assertEquals(6.0, calculator.multiply(-2.0, -3.0), 0.001)
        
        // Тест умножения положительного и отрицательного числа
        assertEquals(-6.0, calculator.multiply(2.0, -3.0), 0.001)
        
        // Тест умножения дробных чисел
        assertEquals(3.0, calculator.multiply(1.5, 2.0), 0.001)
    }
    
    @Test
    fun testDivide() {
        // Тест деления положительных чисел
        assertEquals(2.0, calculator.divide(6.0, 3.0), 0.001)
        
        // Тест деления на единицу
        assertEquals(5.0, calculator.divide(5.0, 1.0), 0.001)
        
        // Тест деления нуля
        assertEquals(0.0, calculator.divide(0.0, 5.0), 0.001)
        
        // Тест деления отрицательных чисел
        assertEquals(2.0, calculator.divide(-6.0, -3.0), 0.001)
        
        // Тест деления положительного на отрицательное
        assertEquals(-2.0, calculator.divide(6.0, -3.0), 0.001)
        
        // Тест деления дробных чисел
        assertEquals(2.5, calculator.divide(5.0, 2.0), 0.001)
    }
    
    @Test
    fun testPower() {
        // Тест возведения в степень
        assertEquals(8.0, calculator.power(2.0, 3.0), 0.001)
        
        // Тест возведения в степень 0
        assertEquals(1.0, calculator.power(5.0, 0.0), 0.001)
        
        // Тест возведения в степень 1
        assertEquals(5.0, calculator.power(5.0, 1.0), 0.001)
        
        // Тест возведения в отрицательную степень
        assertEquals(0.25, calculator.power(2.0, -2.0), 0.001)
        
        // Тест возведения в дробную степень
        assertEquals(2.0, calculator.power(4.0, 0.5), 0.001)
    }
    
    @Test
    fun testSquareRoot() {
        // Тест квадратного корня из положительного числа
        assertEquals(3.0, calculator.squareRoot(9.0), 0.001)
        
        // Тест квадратного корня из нуля
        assertEquals(0.0, calculator.squareRoot(0.0), 0.001)
        
        // Тест квадратного корня из единицы
        assertEquals(1.0, calculator.squareRoot(1.0), 0.001)
        
        // Тест квадратного корня из дробного числа
        assertEquals(1.5, calculator.squareRoot(2.25), 0.001)
    }
    
    @Test(expected = IllegalArgumentException::class)
    fun testSquareRootOfNegative() {
        calculator.squareRoot(-4.0)
    }
    
    @Test
    fun testEdgeCases() {
        // Тест очень больших чисел
        assertEquals(2e15, calculator.add(1e15, 1e15), 1e10)
        
        // Тест очень маленьких чисел
        assertEquals(2e-15, calculator.add(1e-15, 1e-15), 1e-20)
        
        // Тест точности вычислений
        val result = calculator.add(0.1, 0.2)
        assertTrue(result > 0.299 && result < 0.301)
    }
    
    @Test
    fun testMathematicalProperties() {
        val a = 5.0
        val b = 3.0
        val c = 2.0
        
        // Тест коммутативности сложения
        assertEquals(calculator.add(a, b), calculator.add(b, a), 0.001)
        
        // Тест коммутативности умножения
        assertEquals(calculator.multiply(a, b), calculator.multiply(b, a), 0.001)
        
        // Тест ассоциативности сложения
        val left = calculator.add(calculator.add(a, b), c)
        val right = calculator.add(a, calculator.add(b, c))
        assertEquals(left, right, 0.001)
        
        // Тест дистрибутивности
        val distributiveLeft = calculator.multiply(a, calculator.add(b, c))
        val distributiveRight = calculator.add(calculator.multiply(a, b), calculator.multiply(a, c))
        assertEquals(distributiveLeft, distributiveRight, 0.001)
    }
}
