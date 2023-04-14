package com.melatech.calculatorapp.calculator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*

class CalculatorViewModel: ViewModel() {

    private val _state1: MutableStateFlow<String> = MutableStateFlow("")
    val state1: StateFlow<String> = _state1.asStateFlow()

    private val _state2: MutableStateFlow<String> = MutableStateFlow("")
    val state2: StateFlow<String> = _state2.asStateFlow()

    private val _operator: MutableStateFlow<String?> = MutableStateFlow(null)
    val operator: StateFlow<String?> = _operator.asStateFlow()

    private val _result: MutableStateFlow<String> = MutableStateFlow("")
    val result: StateFlow<String> = _result.asStateFlow()

    fun enterNumber(number: String){
       // val newDisplay = _state1.value + number

        if (_operator.value == null) {

            //check if operator is empty
            if (_state1.value.length >= MAX_NUM_LENGTH) {
                //if it is  empty we can append more numbers until the cut of point of 8
                return
            }
        }
        //check if state1 is empty and assign result to _state1.value
        _state1.value = if (_state1.value == ""){
            //if it is empty return the parameter value
            "$number"
        } else {
            //if there is something in the state return the state with the previous multiple values
            //and the parameter value at the end

            "${_state1.value} $number"
        }
       if (_operator.value != null){
           if (_state2.value == ""){
               "$number"
           } else {
               "${_state2.value} $number"
           }
        }
    }

//    fun enterNumber(number: String){
//        if (_operator.value == null){
//            if (_state1.value.length >= MAX_NUM_LENGTH ){
//                return
//            }
//        }
//        _state1.value = if (_state1.value == ""){
//            "$number"
//        } else {
//            "${_state1.value} $number"
//        }
//    }

    fun performOperation(symbol: String){
        _operator.value = symbol

    }

    fun performCalculation(){
        combine(_state1, state2, _operator){
            state1, state2, operator1 ->
            Triple(state1, state2, operator1)

            val number1 = state1.toInt()
            val number2 = state2.toInt()

         val result =    when(operator1){
                "+" -> {number1 + number2}
                "-" -> {number1 - number2}
                "*" -> {number1 * number2}
                "/" -> {number1 / number2}
          else -> ""

            }
            _result.value = result.toString() ?: ""

        }


    }

    fun performClearScreen(){
        _state1.value = ""
        _state2.value = ""
        _operator.value = ""

    }

companion object {
    private const val MAX_NUM_LENGTH = 9
}

}