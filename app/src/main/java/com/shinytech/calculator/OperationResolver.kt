package com.shinytech.calculator

class OperationResolver(
    private var numberOne: String,
    private var numberTwo: String,
    private var operationSign: String
) {

    fun resolve(): String {
        var result = ""
         try {
             if (numberTwo=="0" && operationSign=="÷"){
                 return "M'enfin ?!"
             }
            val num1 = numberOne.toDouble()
            val num2 = numberTwo.toDouble()
            result = performOperation(num1, num2).toString()
            if (result.endsWith((".0"))){
                result = result.substring(
                    0, result.length-2
                )
            }
        } catch (e: NumberFormatException) {
            return result
        } catch (e: ArithmeticException) {
            return result
        }
        return result
    }

    private fun performOperation(numberOne: Double, numberTwo: Double): Double {
        return when (operationSign) {
            "+" -> numberOne + numberTwo
            "−" -> numberOne - numberTwo
            "x" -> numberOne * numberTwo
            "÷" -> numberOne / numberTwo
            else -> numberOne % numberTwo
        }
    }
}