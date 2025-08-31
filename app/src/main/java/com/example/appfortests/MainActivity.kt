package com.example.appfortests

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.appfortests.ui.theme.AppForTestsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppForTestsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CalculatorScreen()
                }
            }
        }
    }
}

@Composable
fun CalculatorScreen() {
    val calculator = remember { Calculator() }
    var firstNumber by remember { mutableStateOf("") }
    var secondNumber by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var operation by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "ОЧЕНЬ Простой Калькулятор",
            style = MaterialTheme.typography.headlineMedium
        )

        OutlinedTextField(
            value = firstNumber,
            onValueChange = { firstNumber = it },
            label = { Text("Первое число") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = secondNumber,
            onValueChange = { secondNumber = it },
            label = { Text("Второе число") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = {
                    operation = "+"
                    try {
                        val a = firstNumber.toDouble()
                        val b = secondNumber.toDouble()
                        result = calculator.add(a, b).toString()
                    } catch (e: Exception) {
                        result = "Ошибка: ${e.message}"
                    }
                }
            ) {
                Text("+")
            }

            Button(
                onClick = {
                    operation = "-"
                    try {
                        val a = firstNumber.toDoubleOrNull() ?: 0.0
                        val b = secondNumber.toDoubleOrNull() ?: 0.0
                        result = calculator.subtract(a, b).toString()
                    } catch (e: Exception) {
                        result = "Ошибка: ${e.message}"
                    }
                }
            ) {
                Text("-")
            }

            Button(
                onClick = {
                    operation = "*"
                    try {
                        val a = firstNumber.toDoubleOrNull() ?: 0.0
                        val b = secondNumber.toDoubleOrNull() ?: 0.0
                        result = calculator.multiply(a, b).toString()
                    } catch (e: Exception) {
                        result = "Ошибка: ${e.message}"
                    }
                }
            ) {
                Text("×")
            }

            Button(
                onClick = {
                    operation = "/"
                    try {
                        val a = firstNumber.toDoubleOrNull() ?: 0.0
                        val b = secondNumber.toDoubleOrNull() ?: 0.0
                        if (b != 0.0) {
                            result = calculator.divide(a, b).toString()
                        } else {
                            result = "Ошибка: Деление на ноль"
                        }
                    } catch (e: Exception) {
                        result = "Ошибка: ${e.message}"
                    }
                }
            ) {
                Text("÷")
            }
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = {
                    operation = "^"
                    try {
                        val a = firstNumber.toDoubleOrNull() ?: 0.0
                        val b = secondNumber.toDoubleOrNull() ?: 0.0
                        result = calculator.power(a, b).toString()
                    } catch (e: Exception) {
                        result = "Ошибка: ${e.message}"
                    }
                }
            ) {
                Text("^")
            }

            Button(
                onClick = {
                    operation = "√"
                    try {
                        val a = firstNumber.toDoubleOrNull() ?: 0.0
                        result = calculator.squareRoot(a).toString()
                    } catch (e: Exception) {
                        result = "Ошибка: ${e.message}"
                    }
                }
            ) {
                Text("√")
            }
        }

        if (result.isNotEmpty()) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Результат вычислений:",
                        style = MaterialTheme.typography.labelMedium
                    )
                    Text(
                        text = result,
                        style = MaterialTheme.typography.headlineSmall
                    )
                    if (operation.isNotEmpty()) {
                        Text(
                            text = "Операция: $operation",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }

        Button(
            onClick = {
                firstNumber = ""
                secondNumber = ""
                result = ""
                operation = ""
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.error
            )
        ) {
            Text("Очистить все значения")
        }
    }
}