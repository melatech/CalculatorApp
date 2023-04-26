package com.melatech.calculatorapp.calculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.melatech.calculatorapp.R
import com.melatech.calculatorapp.calculator.util.CalculatorAction
import com.melatech.calculatorapp.calculator.util.CalculatorOperation
import kotlinx.coroutines.launch

class CalculatorFragment : Fragment() {

    private val viewModel by viewModels<CalculatorViewModel>()

    private lateinit var resultView: TextView
    private lateinit var btnOne: Button
    private lateinit var btnTwo: Button
    private lateinit var btnThree: Button
    private lateinit var btnFour: Button
    private lateinit var btnFive: Button
    private lateinit var btnSix: Button
    private lateinit var btnSeven: Button
    private lateinit var btnEight: Button
    private lateinit var btnNine: Button
    private lateinit var btnZero: Button

    private lateinit var btnAdd: Button
    private lateinit var btnSubtract: Button
    private lateinit var btnMultiply: Button
    private lateinit var btnDivide: Button
    private lateinit var btnEquals: Button

    private lateinit var btnDecimal: Button
    private lateinit var btnDelete: Button
    private lateinit var btnClear: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        resultView = view.findViewById(R.id.tv_results)
        btnZero = view.findViewById(R.id.btn_zero)
        btnOne = view.findViewById(R.id.btn_one)
        btnTwo = view.findViewById(R.id.btn_two)
        btnThree = view.findViewById(R.id.btn_three)
        btnFour = view.findViewById(R.id.btn_four)
        btnFive = view.findViewById(R.id.btn_five)
        btnSix = view.findViewById(R.id.btn_six)
        btnSeven = view.findViewById(R.id.btn_seven)
        btnEight = view.findViewById(R.id.btn_eight)
        btnNine = view.findViewById(R.id.btn_nine)
        btnZero = view.findViewById(R.id.btn_zero)
        btnAdd = view.findViewById(R.id.btn_add)
        btnSubtract = view.findViewById(R.id.btn_subtract)
        btnMultiply = view.findViewById(R.id.btn_multiply)
        btnDivide = view.findViewById(R.id.btn_divide)

        btnDecimal = view.findViewById(R.id.btn_decimal)
        btnEquals = view.findViewById(R.id.btn_equals)
        btnDelete = view.findViewById(R.id.btn_back_space)
        btnClear = view.findViewById(R.id.btn_all_clear)

        btnZero.setOnClickListener { onZeroBtnClick() }
        btnOne.setOnClickListener { onOneBtnClick() }
        btnTwo.setOnClickListener { onTwoBtnClick() }
        btnThree.setOnClickListener { onThreeBtnClick() }
        btnFour.setOnClickListener { onFourBtnClick() }
        btnFive.setOnClickListener { onFiveBtnClick() }
        btnSix.setOnClickListener { onSixBtnClick() }
        btnSeven.setOnClickListener { onSevenBtnClick() }
        btnEight.setOnClickListener { onEightBtnClick() }
        btnNine.setOnClickListener { onNineBtnClick() }
        btnDelete.setOnClickListener { onClearBtnClick() }
        btnAdd.setOnClickListener { onAddOperatorClick() }
        btnSubtract.setOnClickListener { onSubtractOperatorClick() }
        btnMultiply.setOnClickListener { onMultiplyOperatorClick() }
        btnDivide.setOnClickListener { onDivideOperatorClick() }

        btnAdd.setOnClickListener { onAddOperatorClick() }
        btnSubtract.setOnClickListener { onSubtractOperatorClick() }
        btnMultiply.setOnClickListener { onMultiplyOperatorClick() }
        btnDivide.setOnClickListener { onDivideOperatorClick() }

        btnDecimal.setOnClickListener {onDecimalClick()}
        btnDelete.setOnClickListener {onDeleteBtnClick()}
        btnClear.setOnClickListener {onClearBtnClick()}
        btnEquals.setOnClickListener { onEqualsClick() }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                launch {
                    viewModel.state.collect{ state ->
                        resultView.text = getString(R.string.result_text_value, state)
                    }
                }
            }
        }
    }

    //---------------------- operation buttons -------------------------

    private fun onAddOperatorClick() {
        viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Add))
    }

    private fun onSubtractOperatorClick() {
        viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
    }

    private fun onMultiplyOperatorClick() {
        viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
    }

    private fun onDivideOperatorClick() {
        viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
    }

    private fun onDecimalClick() {
        viewModel.performCalculation()
    }

    private fun onEqualsClick() {
        viewModel.performCalculation()
    }

    private fun onClearBtnClick() {
        viewModel.performClearScreen()
    }

    private fun onDeleteBtnClick() {
        viewModel.performDeleteBackSpace()
    }

    //---------------------- numbers buttons -------------------------

    private fun onZeroBtnClick() {
        viewModel.onAction(CalculatorAction.Number(0))
        println("jason onOneBtnClick")
    }

    private fun onOneBtnClick() {
        viewModel.onAction(CalculatorAction.Number(1))
        println("jason onOneBtnClick")
    }

    private fun onTwoBtnClick() {
        viewModel.onAction(CalculatorAction.Number(2))
        println("jason onTwoBtnClick")
    }

    private fun onThreeBtnClick() {
        viewModel.onAction(CalculatorAction.Number(3))
        println("jason onThreeBtnClick")
    }

    private fun onFourBtnClick() {
        viewModel.onAction(CalculatorAction.Number(4))
        println("jason onFourBtnClick")
    }

    private fun onFiveBtnClick() {
        viewModel.onAction(CalculatorAction.Number(5))
        println("jason onFiveBtnClick")
    }

    private fun onSixBtnClick() {
        viewModel.onAction(CalculatorAction.Number(6))
        println("jason onSixBtnClick")
    }

    private fun onSevenBtnClick() {
        viewModel.onAction(CalculatorAction.Number(7))
        println("jason onSevenBtnClick")
    }

    private fun onEightBtnClick() {
        viewModel.onAction(CalculatorAction.Number(8))
        println("jason onEightBtnClick")
    }

    private fun onNineBtnClick() {
        viewModel.onAction(CalculatorAction.Number(9))
        println("jason onNineBtnClick")
    }
}