package com.shinytech.calculator

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.shinytech.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<CalculatorViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                val textToDisplay = viewModel.numberDisplayed.collectAsState()

                Box(modifier = Modifier.fillMaxSize().background(Color.DarkGray)) {
                    Scaffold(
                        content = { paddingValues ->
                            Column(
                                modifier = Modifier
                                    .matchParentSize()
                                    .padding(paddingValues)
                            ) {

                                // Display area
                                Box(
                                    modifier = Modifier
                                        .weight(2f)
                                        .background(Color.DarkGray)
                                        .fillMaxWidth()
                                        .padding(20.dp),
                                    contentAlignment = Alignment.BottomEnd
                                ) {
                                    Text(
                                        text = textToDisplay.value,
                                        textAlign = TextAlign.End,
                                        fontWeight = FontWeight.Light,
                                        lineHeight = 1.em,
                                        fontSize = 50.sp,
                                        color = Color.White,
                                        maxLines = 2
                                    )
                                }

                                // this factorization is chatgpt made
                                listOf(
                                    listOf("AC", "%", "+/-", "÷"),
                                    listOf("7", "8", "9", "x"),
                                    listOf("4", "5", "6", "−"),
                                    listOf("1", "2", "3", "+"),
                                    listOf("0", ".", "⌫", "=")
                                ).forEach { row ->
                                    Row(
                                        modifier = Modifier.weight(1f),
                                        horizontalArrangement = Arrangement.SpaceEvenly
                                    ) {
                                        row.forEach { symbol ->
                                            CalculatorButton(
                                                Modifier.weight(2f),
                                                if (symbol in listOf("÷", "x", "−", "+", "=")) Color(0xFFFF8F00) else Color(0xFFF5F5F5),
                                                symbol,
                                                if (symbol in listOf("÷", "x", "−", "+", "=")) Color.White else Color.Black,

                                            )
                                        }
                                    }
                                }
                            }
                        }
                    )
                }
                }


        }
    }
}







