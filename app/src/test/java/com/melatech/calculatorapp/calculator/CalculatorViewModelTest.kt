package com.melatech.calculatorapp.calculator

import com.melatech.calculatorapp.calculator.util.CalculatorAction
import com.melatech.calculatorapp.calculator.util.CalculatorOperation
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CalculatorViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()
    private lateinit var viewmodel: CalculatorViewModel

    @Before
    fun setUp() {
        viewmodel = CalculatorViewModel()
    }

    @Test
    fun `viewModel should add two numbers and return the correct result`() = runBlocking{

        //mimic the first number button click to update operand1 stateflow with integer 4
        viewmodel.onAction(CalculatorAction.Number(4))

        //check that operand 1 stateflow has been updated the with integer 4
        val actualOperand1 = viewmodel.state.value.operand1
        assertEquals("4", actualOperand1)

        //mimic the operator button click to update the operator stateflow with the string symbol "+"
        viewmodel.onAction(CalculatorAction.Operation(CalculatorOperation.Add))

        //check that operator stateflow has been updated with with the string symbol "+"
        val actualOperator = viewmodel.state.value.operator?.symbol
        assertEquals("+", actualOperator)

        //mimic the second number button click to update operand2 stateflow with the integer 2
        viewmodel.onAction(CalculatorAction.Number(2))

        //check that operand 2 stateflow has been updated with the integer 2
        val actualOperand2 = viewmodel.state.value.operand2
        assertEquals("2", actualOperand2)

        //mimic the equals button click to update operand1 stateflow with the correct result
        viewmodel.onAction(CalculatorAction.Calculate)

        //check that operand 1 stateflow has been updated with the correct result
        val actualResult = viewmodel.state.value.operand1
        assertEquals("6.0", actualResult)
    }

    @Test
    fun `viewModel should Multiply two numbers and return the correct result`() = runBlocking{

        //mimic the first number button click to update operand1 stateflow with integer 4
        viewmodel.onAction(CalculatorAction.Number(4))

        //check that operand 1 stateflow has been updated the with integer 4
        val actualOperand1 = viewmodel.state.value.operand1
        assertEquals("4", actualOperand1)

        //mimic the operator button click to update the operator stateflow with the string symbol "*"
        viewmodel.onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))

        //check that operator stateflow has been updated with with the string symbol "*"
        val actualOperator = viewmodel.state.value.operator?.symbol
        assertEquals("*", actualOperator)

        //mimic the second number button click to update operand2 stateflow with the integer 4
        viewmodel.onAction(CalculatorAction.Number(4))

        //check that operand 2 stateflow has been updated with the integer 4
        val actualOperand2 = viewmodel.state.value.operand2
        assertEquals("4", actualOperand2)

        //mimic the equals button click to update operand1 stateflow with the correct result
        viewmodel.onAction(CalculatorAction.Calculate)

        //check that operand 1 stateflow has been updated with the correct result
        val actualResult = viewmodel.state.value.operand1
        assertEquals("16.0", actualResult)
    }

    @Test
    fun `viewModel should Subtract two numbers and return the correct result`() = runBlocking{

        //mimic the first number button click to update operand1 stateflow with integer 40
        viewmodel.onAction(CalculatorAction.Number(40))

        //check that operand 1 stateflow has been updated the with integer 4
        val actualOperand1 = viewmodel.state.value.operand1
        assertEquals("40", actualOperand1)

        //mimic the operator button click to update the operator stateflow with the string symbol "-"
        viewmodel.onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))

        //check that operator stateflow has been updated with with the string symbol "-"
        val actualOperator = viewmodel.state.value.operator?.symbol
        assertEquals("-", actualOperator)

        //mimic the second number button click to update operand2 stateflow with the integer 10
        viewmodel.onAction(CalculatorAction.Number(10))

        //check that operand 2 stateflow has been updated with the integer 10
        val actualOperand2 = viewmodel.state.value.operand2
        assertEquals("10", actualOperand2)

        //mimic the equals button click to update operand1 stateflow with the correct result
        viewmodel.onAction(CalculatorAction.Calculate)

        //check that operand 1 stateflow has been updated with the correct result
        val actualResult = viewmodel.state.value.operand1
        assertEquals("30.0", actualResult)
    }

    @Test
    fun `viewModel should Divide two numbers and return the correct result`() = runBlocking{

        //mimic the first number button click to update operand1 stateflow with integer 100
        viewmodel.onAction(CalculatorAction.Number(100))

        //check that operand 1 stateflow has been updated the with integer 4
        val actualOperand1 = viewmodel.state.value.operand1
        assertEquals("100", actualOperand1)

        //mimic the operator button click to update the operator stateflow with the string symbol "/"
        viewmodel.onAction(CalculatorAction.Operation(CalculatorOperation.Divide))

        //check that operator stateflow has been updated with with the string symbol "/"
        val actualOperator = viewmodel.state.value.operator?.symbol
        assertEquals("/", actualOperator)

        //mimic the second number button click to update operand2 stateflow with the integer 10
        viewmodel.onAction(CalculatorAction.Number(10))

        //check that operand 2 stateflow has been updated with the integer 4
        val actualOperand2 = viewmodel.state.value.operand2
        assertEquals("10", actualOperand2)

        //mimic the equals button click to update operand1 stateflow with the correct result
        viewmodel.onAction(CalculatorAction.Calculate)

        //check that operand 1 stateflow has been updated with the correct result
        val actualResult = viewmodel.state.value.operand1
        assertEquals("10.0", actualResult)
    }
}