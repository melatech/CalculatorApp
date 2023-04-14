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
import kotlinx.coroutines.launch

class CalculatorFragment : Fragment() {

    private val viewModel by viewModels<CalculatorViewModel>()

    private lateinit var resultView: TextView
    private lateinit var workingsView: TextView
    private lateinit var btnDelete: Button
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
    private lateinit var btnDivide: Button
    private lateinit var btnMultiply: Button
    private lateinit var btnSubtract: Button
    private lateinit var btnAdd: Button
    private lateinit var btnDecimal: Button
    private lateinit var btnEquals: Button

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
        workingsView = view.findViewById(R.id.tv_workings)
        btnDelete = view.findViewById(R.id.btn_all_clear)
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

        btnDivide = view.findViewById(R.id.btn_divide)
        btnMultiply = view.findViewById(R.id.btn_multiply)
        btnSubtract = view.findViewById(R.id.btn_subtract)
        btnAdd = view.findViewById(R.id.btn_add)
        btnDecimal = view.findViewById(R.id.btn_decimal)
        btnEquals = view.findViewById(R.id.btn_equals)

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
        btnEquals.setOnClickListener { onEqualsClick() }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                launch {
                    viewModel.state1.collect{ number1 ->
                        resultView.text = getString(R.string.result_text_value, number1)
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                launch {
                    viewModel.state2.collect{ number2 ->
                        resultView.text = getString(R.string.result_text_value, number2)
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                launch {
                    viewModel.operator.collect{ operator ->
                        resultView.text = getString(R.string.result_text_value, operator)
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                launch {
                    viewModel.result.collect{ result ->
                        resultView.text = getString(R.string.result_text_value, result)
                    }
                }
            }
        }

    }

    private fun onClearBtnClick() {
        viewModel.performClearScreen()
        println("jason onClearBtnClick")
    }

    private fun onAddOperatorClick() {
        viewModel.performOperation("+")
        println("jason onAddOperatorClick")
    }

    private fun onSubtractOperatorClick() {
        viewModel.performOperation("-")
        println("jason onSubtractOperatorClick")
    }

    private fun onMultiplyOperatorClick() {
        viewModel.performOperation("*")
        println("jason onMultiplyOperatorClick")
    }

    private fun onDivideOperatorClick() {
        viewModel.performOperation("/")
        println("jason onDivideOperatorClick")
    }

    private fun onEqualsClick() {
        viewModel.performCalculation()
        println("jason onEqualsClick")
    }

    //---------------------- numbers buttons -------------------------

    private fun onZeroBtnClick() {
        viewModel.enterNumber("0")
        println("jason onOneBtnClick")
    }

    private fun onOneBtnClick() {
        viewModel.enterNumber("1")
        println("jason onOneBtnClick")
    }

    private fun onTwoBtnClick() {
        viewModel.enterNumber("2")
        println("jason onTwoBtnClick")
    }

    private fun onThreeBtnClick() {
        viewModel.enterNumber("3")
        println("jason onThreeBtnClick")
    }

    private fun onFourBtnClick() {
        viewModel.enterNumber("4")
        println("jason onFourBtnClick")
    }

    private fun onFiveBtnClick() {
        viewModel.enterNumber("5")
        println("jason onFiveBtnClick")
    }

    private fun onSixBtnClick() {
        viewModel.enterNumber("6")
        println("jason onSixBtnClick")
    }

    private fun onSevenBtnClick() {
        viewModel.enterNumber("7")
        println("jason onSevenBtnClick")
    }

    private fun onEightBtnClick() {
        viewModel.enterNumber("8")
        println("jason onEightBtnClick")
    }

    private fun onNineBtnClick() {
        viewModel.enterNumber("9")
        println("jason onNineBtnClick")
    }

    companion object {

        @JvmStatic
        fun newInstance() = CalculatorFragment()
    }
}