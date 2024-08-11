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
import androidx.compose.foundation.layout.safeDrawingPadding
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

                Box(
                    modifier = Modifier
                        .fillMaxSize()

                        .background(Color.DarkGray)
                )
                {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .safeDrawingPadding()
                            .align(Alignment.BottomCenter),
                        verticalArrangement = Arrangement.spacedBy(1.dp)
                    ) {
                        Text(
                            text = textToDisplay.value,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp),
                            fontWeight = FontWeight.Light,
                            lineHeight = 1.em,
                            fontSize = 40.sp,
                            color = Color.White,
                            maxLines = 2
                        )

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(1.dp)
                        ) {
                            CalculatorButton(
                                Modifier.weight(2f),
                                Color.LightGray,
                                "AC",
                                Color.Black,

                                )
                            CalculatorButton(
                                Modifier.weight(2f),
                                Color.LightGray,
                                "%",
                                Color.Black
                            )
                            CalculatorButton(
                                Modifier.weight(2f),
                                Color.LightGray,
                                "+/-",
                                Color.Black
                            )
                            CalculatorButton(
                                Modifier.weight(2f),
                                Color(0xFFFF8F00),
                                "÷",
                                Color.White
                            )
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(1.5.dp)
                        ) {
                            CalculatorButton(
                                Modifier
                                    .weight(2f),
                                Color(0xFFF5F5F5),
                                "7",
                                Color.Black

                            )
                            CalculatorButton(
                                Modifier.weight(2f),
                                Color(0xFFF5F5F5),
                                "8",
                                Color.Black
                            )
                            CalculatorButton(
                                Modifier.weight(2f),
                                Color(0xFFF5F5F5),
                                "9",
                                Color.Black
                            )
                            CalculatorButton(
                                Modifier.weight(2f),
                                Color(0xFFFF8F00),
                                "x",
                                Color.White
                            )
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(1.5.dp)
                        ) {
                            CalculatorButton(
                                Modifier.weight(2f),
                                Color(0xFFF5F5F5),
                                "4",
                                Color.Black
                            )
                            CalculatorButton(
                                Modifier.weight(2f),
                                Color(0xFFF5F5F5),
                                "5",
                                Color.Black
                            )
                            CalculatorButton(
                                Modifier.weight(2f),
                                Color(0xFFF5F5F5),
                                "6",
                                Color.Black
                            )
                            CalculatorButton(
                                Modifier.weight(2f),
                                Color(0xFFFF8F00),
                                "−",
                                Color.White
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(1.5.dp)
                        ) {
                            CalculatorButton(
                                Modifier.weight(2f),
                                Color(0xFFF5F5F5),
                                "1",
                                Color.Black
                            )
                            CalculatorButton(
                                Modifier.weight(2f),
                                Color(0xFFF5F5F5),
                                "2",
                                Color.Black
                            )
                            CalculatorButton(
                                Modifier.weight(2f),
                                Color(0xFFF5F5F5),
                                "3",
                                Color.Black
                            )
                            CalculatorButton(
                                Modifier.weight(2f),
                                Color(0xFFFF8F00),
                                "+",
                                Color.White
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(1.5.dp)
                        ) {
                            CalculatorButton(
                                Modifier.weight(2f),
                                Color(0xFFF5F5F5),
                                "0",
                                Color.Black
                            )
                            CalculatorButton(
                                Modifier.weight(2f),
                                Color(0xFFF5F5F5),
                                ".",
                                Color.Black
                            )
                            CalculatorButton(
                                Modifier.weight(2f),
                                Color(0xFFF5F5F5),
                                "⌫",
                                Color.Black
                            )
                            CalculatorButton(
                                Modifier.weight(2f),
                                Color(0xFFFF8F00),
                                "=",
                                Color.White
                            )
                        }

                    }
                }

            }


        }
    }


}






