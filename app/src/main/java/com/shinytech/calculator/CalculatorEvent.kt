package com.shinytech.calculator

interface CalculatorEvent  {

  fun onEvent(stringFromUI:String, numberOne:Int, numberTwo:Int) : Int

}