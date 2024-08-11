package com.shinytech.calculator

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CalculatorViewModel : ViewModel() {

    private val operationList = listOf("+", "−", "x", "÷", "%")
    private val _numberDisplayed = MutableStateFlow("")
    val numberDisplayed = _numberDisplayed.asStateFlow()

    fun event(symbol: String) {
        try {
            if (symbol == "AC") {
                _numberDisplayed.value = ""
            } else if (symbol == "⌫") {
                if (_numberDisplayed.value.isNotEmpty()) {
                    _numberDisplayed.value = _numberDisplayed.value.substring(
                        0, _numberDisplayed.value.length - 1
                    )
                }
            } else if (symbol == "=") {
                _numberDisplayed.value = equalEventHandler(symbol)
            } else {
                _numberDisplayed.value += symbol
            }
        }
        catch (e: NumberFormatException) {
            _numberDisplayed.value = ""
        }
    }

    private fun equalEventHandler(symbol: String): String {

        //todo : handle floats
        //todo : +/-

        var numberOne = ""
        var numberTwo = ""
        var operation = ""


            for (c in _numberDisplayed.value) {

                if (operationList.contains(c.toString()) && numberOne != "" && numberTwo != "") {
                    numberOne = OperationResolver(numberOne, numberTwo, operation).resolve()
                    numberTwo = ""
                }
                if (operationList.contains(c.toString())) {
                    operation = c.toString()
                } else if ("" == operation) {
                    numberOne += c
                } else {
                    numberTwo += c
                }

            }

        return OperationResolver(numberOne, numberTwo, operation).resolve()
    }

}