package com.melatech.calculatorapp.calculator

import androidx.lifecycle.ViewModel
import com.melatech.calculatorapp.data.CalculatorModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine

class CalculatorViewModel: ViewModel() {

    private val _state: MutableStateFlow<String> = MutableStateFlow("")
    val state: StateFlow<String> = _state.asStateFlow()

    private val _operator: MutableStateFlow<String> = MutableStateFlow("")
    val operator: StateFlow<String> = _operator.asStateFlow()

    private val _result: MutableStateFlow<String> = MutableStateFlow("")
    val result: StateFlow<String> = _operator.asStateFlow()

    fun enterNumber(number: String){
        if (_state.value == ""){
            return
        }
        _state.value = number
    }

    fun performOperation(symbol: String){
        _operator.value = symbol

    }

    fun performCalculation(){
        _state.value
    }

    fun performClearScreen(){
        _state.value = ""
        _operator.value = ""

    }







}