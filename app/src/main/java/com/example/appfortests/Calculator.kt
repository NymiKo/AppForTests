package com.example.appfortests

import kotlin.math.pow
import kotlin.math.sqrt

class Calculator {

    fun add(a: Double, b: Double): Double {
        return a + b
    }

    fun subtract(a: Double, b: Double): Double {
        return a - b
    }

    fun multiply(a: Double, b: Double): Double {
        return a * b
    }

    fun divide(a: Double, b: Double): Double {
        return a / b
    }

    fun power(base: Double, exponent: Double): Double {
        return base.pow(exponent)
    }

    fun squareRoot(value: Double): Double {
        if (value < 0) {
            throw IllegalArgumentException("Квадратный корень из отрицательного числа недопустим")
        }
        return sqrt(value)
    }
}