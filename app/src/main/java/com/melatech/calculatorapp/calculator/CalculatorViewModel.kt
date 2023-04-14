package com.melatech.calculatorapp.calculator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*

class CalculatorViewModel : ViewModel() {

    private val _state1: MutableStateFlow<String> = MutableStateFlow("")
    val state1: StateFlow<String> = _state1.asStateFlow()

    private val _state2: MutableStateFlow<String> = MutableStateFlow("")
    val state2: StateFlow<String> = _state2.asStateFlow()

    private val _operator: MutableStateFlow<String?> = MutableStateFlow(null)
    val operator: StateFlow<String?> = _operator.asStateFlow()

    private val _result: MutableStateFlow<String> = MutableStateFlow("")
    val result: StateFlow<String> = _result.asStateFlow()

    init {
        println("jason init")
        combine(_state1, _operator, _state2) { s1, op, s2 ->
            println("jason performCalculation2:$s1--$s2--$op")

            val number1 = s1.toInt()
            val number2 = s2.toInt()
            val operator1 = op
            println("jason performCalculation1:number1:$number1--number2:$number2")

            val result = when (operator1) {
                "+" -> {
                    number1 + number2
                    println("jason performCalculation3:$s1--$s2--$op")
                }
                "-" -> {
                    number1 - number2
                }
                "*" -> {
                    number1 * number2
                }
                "/" -> {
                    number1 / number2
                }
                else -> 0
            }
            _result.value = result.toString() ?: ""
        }
            .catch { e ->
                e.message
            }
            .launchIn(viewModelScope)
    }

    fun enterNumber(number: String) {
        println("jason enterNumber: $number")
        println("jason _state1.length: ${_state1.value.length}")
        println("jason _state2.length: ${_state2.value.length}")

        if (_operator.value == null) {
            println("jason enterNumber: _operator:${_operator.value}")
            if (_state1.value.length >= MAX_NUM_LENGTH) {
                //println("jason enterNumber: _state1.length:${_state1.value.length}")
                return
            }
            _state1.value = if (_state1.value == "") {
                "$number"
            } else {
                //"${_state1.value} "
                "${_state1.value}" + "$number"
            }
            return
        }
        if (_state2.value.length >= MAX_NUM_LENGTH) {
            return
        }
        _state2.value = if (_state2.value == "") {
            "$number"
        } else {
            "${_state1.value}" + " " + "${_operator.value}" + " " + "${_state2.value}" + "$number"
        }
    }

    fun performOperation(symbol: String) {
        println("jason performOperation: $symbol")
        if (_state1.value.isNotBlank()) {
            _operator.value = symbol
            _result.value = "${_state1.value}" + " " + "$symbol" + " "
        }
    }

    fun performCalculation() = _result.value

    fun performClearScreen() {
        println("jason performDelete")
        _state1.value = ""
        _state2.value = ""
        _operator.value = ""
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}