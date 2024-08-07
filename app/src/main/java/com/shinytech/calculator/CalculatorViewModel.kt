package com.shinytech.calculator

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CalculatorViewModel(
) : ViewModel() {

    private val _numberDisplayed = MutableStateFlow("")
    val numberDisplayed = _numberDisplayed.asStateFlow()

    fun updateNumberDisplayed(stringFromButton : String) {

            _numberDisplayed.value+=stringFromButton


    }

}