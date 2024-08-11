package com.shinytech.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp


@Composable
fun CalculatorButton(
    modifier: Modifier = Modifier,
    color: Color,
    symbol: String,
    symbolColor: Color,
) {
    val viewModel = androidx.lifecycle.viewmodel.compose.viewModel<CalculatorViewModel>()
    Box(
        contentAlignment = Alignment.Center, modifier = Modifier
            .background(color)
            .aspectRatio(1f)
            .clickable {
                viewModel.event(symbol)
            }
            .then(modifier)
    ) {
        Text(
            text = symbol, fontSize = 50.sp, color = symbolColor
        )
    }

}