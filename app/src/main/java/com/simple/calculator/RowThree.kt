//package com.simple.calculator
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Button
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//
//@Composable
//@Preview
//fun ThirdRow(){
//    val fontSize = Font().fontSize
//    Row(modifier = Modifier.background(MaterialTheme.colorScheme.background).fillMaxWidth().padding(top=10.dp),
//        horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically){
//        Button(onClick = {buttonSix = !buttonSix}, shape = MaterialTheme.shapes.extraLarge) {
//            Text(text = "6", fontSize = fontSize)
//        }
//        Button(onClick = { buttonSeven = !buttonSeven}, shape = MaterialTheme.shapes.extraLarge) {
//            Text(text = "7", fontSize = fontSize)
//        }
//        Button(onClick = { buttonEight = !buttonEight}, shape = MaterialTheme.shapes.extraLarge) {
//            Text(text = "8", fontSize = fontSize)
//        }
//        Button(onClick = { buttonMinus = !buttonMinus}, shape = MaterialTheme.shapes.extraLarge) {
//            Text(text = "-", fontSize = fontSize)
//        }
//    }
//}