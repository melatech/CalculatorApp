package com.melatech.calculatorapp.calculator.util

sealed class CalculatorAction {
    data class Number(val number: Int): CalculatorAction()
    data class Operation(val operation: CalculatorOperation): CalculatorAction()
    object Calculate: CalculatorAction()
}