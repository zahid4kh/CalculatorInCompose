package com.simple.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simple.calculator.ui.theme.CalculatorSimpleTheme
import com.simple.calculator.ui.theme.displayFontFamily

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


@Composable
@Preview
fun App(){
    val fontSize = Font().fontSize
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var result by remember {mutableStateOf ("")}

    var isInputtingNum1 by remember { mutableStateOf(true) }
    var currentOperator by remember {mutableStateOf<String?>(null)}

    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally){

        TextField(value = result,
            onValueChange = {result = it},
            textStyle = TextStyle(fontSize=60.sp, textAlign = TextAlign.End, fontFamily = displayFontFamily),
            maxLines = 1,
            readOnly = true,
            modifier=Modifier.fillMaxWidth())


        fun onDigitClicked(digit:String){
            if (isInputtingNum1){
                num1 += digit
                result = num1
            }else{
                num2 += digit
                result = num1 + currentOperator + num2
            }
        }
        fun onEqualsClicked(){
            if (currentOperator != null && num2.isNotEmpty()){
                when (currentOperator){
                    "+" -> result = (num1.toDouble() + num2.toDouble()).toString()
                    "-" -> result = (num1.toDouble() - num2.toDouble()).toString()
                    "*" -> result = (num1.toDouble() * num2.toDouble()).toString()
                    "/" -> result = if (num2 !="0") (num1.toDouble() / num2.toDouble()).toString() else "Error"
                }
            }
            num1 = ""
            num2 = ""
            currentOperator = null
            isInputtingNum1 = true
        }
        fun onClearClicked(){
            result = ""
            num1 = ""
            num2 = ""
            currentOperator = null
        }
        fun onOperatorClicked(operator: String){
            if (num1.isNotEmpty() && num2.isEmpty()){
                currentOperator = operator
                result = num1 + operator
                isInputtingNum1 = false
            } else if (num1.isNotEmpty() && num2.isNotEmpty()){
                onEqualsClicked()
                currentOperator = operator
                result = num1 + operator
                isInputtingNum1 = false
            }

        }

        Row(modifier = Modifier.background(MaterialTheme.colorScheme.background).fillMaxWidth().padding(top = 15.dp),
            horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically){
            Button(onClick = {onClearClicked(); isInputtingNum1 = true}, shape = MaterialTheme.shapes.extraLarge) {
                Text(text = "C", fontSize = fontSize, fontFamily = displayFontFamily)
            }
            Button(onClick = {onDigitClicked("9")}, shape = MaterialTheme.shapes.extraLarge) {
                Text(text = "9", fontSize = fontSize, fontFamily = displayFontFamily)
            }
            Button(onClick = {onEqualsClicked(); isInputtingNum1 = true}, shape = MaterialTheme.shapes.extraLarge) {
                Text(text = "=", fontSize = fontSize, fontFamily = displayFontFamily)
            }
            Button(onClick = {onOperatorClicked("/"); isInputtingNum1 = false}, shape = MaterialTheme.shapes.extraLarge) {
                Text(text = "/", fontSize = fontSize, fontFamily = displayFontFamily)
            }
        }
        Row(modifier = Modifier.background(MaterialTheme.colorScheme.background).fillMaxWidth().padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically){
            Button(onClick = {onDigitClicked("6")}, shape = MaterialTheme.shapes.extraLarge) {
                Text(text = "6", fontSize = fontSize, fontFamily = displayFontFamily)
            }
            Button(onClick = {onDigitClicked("7")}, shape = MaterialTheme.shapes.extraLarge) {
                Text(text = "7", fontSize = fontSize, fontFamily = displayFontFamily)
            }
            Button(onClick = {onDigitClicked("8")}, shape = MaterialTheme.shapes.extraLarge) {
                Text(text = "8", fontSize = fontSize, fontFamily = displayFontFamily)
            }
            Button(onClick = {onOperatorClicked("-"); isInputtingNum1 = false}, shape = MaterialTheme.shapes.extraLarge) {
                Text(text = "-", fontSize = fontSize, fontFamily = displayFontFamily)
            }
        }
        Row(modifier = Modifier.background(MaterialTheme.colorScheme.background).fillMaxWidth().padding(bottom = 10.dp, top = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically){
            Button(onClick = {onDigitClicked("3")}, shape = MaterialTheme.shapes.extraLarge) {
                Text(text = "3", fontSize = fontSize, fontFamily = displayFontFamily)
            }
            Button(onClick = {onDigitClicked("4")}, shape = MaterialTheme.shapes.extraLarge) {
                Text(text = "4", fontSize = fontSize, fontFamily = displayFontFamily)
            }
            Button(onClick = {onDigitClicked("5")}, shape = MaterialTheme.shapes.extraLarge) {
                Text(text = "5", fontSize = fontSize, fontFamily = displayFontFamily)
            }
            Button(onClick = {onOperatorClicked("*"); isInputtingNum1 = false}, shape = MaterialTheme.shapes.extraLarge) {
                Text(text = "*", fontSize = fontSize, fontFamily = displayFontFamily)
            }
        }
        Row(modifier = Modifier.background(MaterialTheme.colorScheme.background).fillMaxWidth().padding(bottom = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically){
            Button(onClick = {onDigitClicked("0")}, shape = MaterialTheme.shapes.extraLarge) {
                Text(text = "0", fontSize = fontSize, fontFamily = displayFontFamily)
            }
            Button(onClick = {onDigitClicked("1")}, shape = MaterialTheme.shapes.extraLarge) {
                Text(text = "1", fontSize = fontSize, fontFamily = displayFontFamily)
            }
            Button(onClick = {onDigitClicked("2")}, shape = MaterialTheme.shapes.extraLarge) {
                Text(text = "2", fontSize = fontSize, fontFamily = displayFontFamily)
            }
            Button(onClick = {onOperatorClicked("+"); isInputtingNum1 = false}, shape = MaterialTheme.shapes.extraLarge) {
                Text(text = "+", fontSize = fontSize, fontFamily = displayFontFamily)
            }
        }
    }
}
