package com.melatech.calculatorapp.calculator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melatech.calculatorapp.calculator.util.CalculatorAction
import com.melatech.calculatorapp.calculator.util.CalculatorOperation
import com.melatech.calculatorapp.data.CalculatorState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class CalculatorViewModel : ViewModel() {

    private val _state: MutableStateFlow<CalculatorState> = MutableStateFlow(CalculatorState())
    val state: StateFlow<CalculatorState> = _state.asStateFlow()

    fun onAction(action: CalculatorAction) {

    }

    fun performCalculation() {
        val number1 = _state.value.operand1.toIntOrNull()
        val number2 = _state.value.operand2.toIntOrNull()
        val operator = _state.value.operator
        if (number1 != null && number2 != null) {
            val result =
                when (operator) {
                    is CalculatorOperation.Add -> (number1 + number2)
                    is CalculatorOperation.Subtract -> (number1 - number2)
                    is CalculatorOperation.Multiply -> (number1 * number2)
                    is CalculatorOperation.Divide -> (number1 / number2)
                    null -> return
                }
        }
    }

    fun enterNumber(number: String) {
        println("jason enterNumber: $number")
        println("jason _state1.length: ${_state.value.operand1.length}")
        println("jason _state2.length: ${_state.value.operand2.length}")

        if (_state.value.operator == null) {
            if (_state.value.operand1.length >= MAX_NUM_LENGTH) {
                return
            }
            _state.value = _state.value.copy(
                operand1 = _state.value.operand1 + number
            )
        }
        if (_state.value.operand2.length >= MAX_NUM_LENGTH) {
            return
        }
        _state.value = _state.value.copy(
            operand2 = _state.value.operand2 + number
        )
    }

    fun enterOperator(operator: CalculatorOperation) {
        println("jason enterOperator: $operator")
        if (_state.value.operand1.isNotBlank()) {
            _state.value = _state.value.copy(
                operator = operator
            )
        }
    }

    fun enterDecimal() {
    }

    fun performClearScreen() {
    }

    fun performDeleteBackSpace() {
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}

