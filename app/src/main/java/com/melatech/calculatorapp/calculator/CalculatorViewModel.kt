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
        when (action) {
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Clear -> performClearScreen()
            is CalculatorAction.Delete -> performDeleteBackSpace()
            is CalculatorAction.Operation -> enterOperator(action.operation)
            is CalculatorAction.Calculate -> performCalculation()
        }
    }

    private fun enterNumber(number: Int) {
        if (_state.value.operator == null) {
            if (_state.value.operand1.length >= MAX_NUM_LENGTH) {
                return
            }
            _state.value = _state.value.copy(
                operand1 = _state.value.operand1 + number
            )
            return
        }
        if (_state.value.operand2.length >= MAX_NUM_LENGTH) {
            return
        }
        _state.value = _state.value.copy(
            operand2 = _state.value.operand2 + number
        )
    }

    private fun enterOperator(operator: CalculatorOperation) {
        println("jason enterOperator: $operator")
        if (_state.value.operand1.isNotBlank()) {
            _state.value = _state.value.copy(
                operator = operator
            )
        }
    }

    private fun enterDecimal() {
        if (_state.value.operator == null && !_state.value.operand1.contains(".")
            && _state.value.operand1.isNotBlank()
        ){
            _state.value = _state.value.copy(
                operand1 = "."
            )
            return
        }
        if (!_state.value.operand2.contains(".") && _state.value.operand2.isNotBlank()){
            _state.value = _state.value.copy(
                operand2 = "."
            )
        }
    }

    private fun performClearScreen() {
        _state.value = _state.value.copy(
            operand1 = "",
            operand2 = "",
            operator = null
        )
    }

    private fun performDeleteBackSpace() {
        when {
            _state.value.operand2.isNotBlank() -> _state.value = _state.value.copy(
                operand2 = _state.value.operand2.dropLast(1)
            )

            _state.value.operator != null -> _state.value = _state.value.copy(
                operator = null
            )

            _state.value.operand1.isNotBlank() -> _state.value = _state.value.copy(
                operand1 = _state.value.operand1.dropLast(1)
            )
        }
    }

    fun performCalculation() {
        val number1 = _state.value.operand1.toDoubleOrNull()
        val number2 = _state.value.operand2.toDoubleOrNull()
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
            _state.value = _state.value.copy(
                operand1 = result.toString().take(15),
                operand2 = "",
                operator = null
            )
        }
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}

