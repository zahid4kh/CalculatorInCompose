package com.simple.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.simple.calculator.ui.theme.CalculatorSimpleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorSimpleTheme {
                App()
            }
        }
    }
}

var buttonOne = false
var buttonTwo = false
var buttonThree = false
var buttonFour = false
var buttonFive = false
var buttonSix = false
var buttonSeven = false
var buttonEight = false
var buttonNine = false
var buttonZero = false
var buttonDiv = false
var buttonPlus = false
var buttonTimes = false
var buttonMinus = false
var buttonPi = false
var buttonDot = false

@Composable
@Preview
fun App(){
    var num1 by remember { mutableStateOf(0.0) }
    var num2 by remember { mutableStateOf(0.0) }
    var result by remember {mutableStateOf (num1 + num2)}

    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally){

        TextField(value = result.toString(),
            onValueChange = {result = it.toDouble()},
            textStyle = TextStyle(fontSize=60.sp, textAlign = TextAlign.End),
            maxLines = 1,
            modifier=Modifier.fillMaxWidth())

        FourthRow()
        ThirdRow()
        SecondRow()
        FirstRow()
    }
}