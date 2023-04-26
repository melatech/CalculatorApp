package com.melatech.calculatorapp.data

import com.melatech.calculatorapp.calculator.util.CalculatorOperation

data class CalculatorState(
    val operand1: String = "",
    val operand2: String = "",
    val operator: CalculatorOperation? = null
)
