package com.simple.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun FirstRow(){
    val fontSize = Font().fontSize
    Row(modifier = Modifier.background(MaterialTheme.colorScheme.background).fillMaxWidth().padding(bottom=10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically){
        Button(onClick = {buttonZero = !buttonZero}, shape = MaterialTheme.shapes.extraLarge) {
            Text(text = "0", fontSize = fontSize)
        }
        Button(onClick = {buttonOne = !buttonOne}, shape = MaterialTheme.shapes.extraLarge) {
            Text(text = "1", fontSize = fontSize)
        }
        Button(onClick = {buttonTwo = !buttonTwo}, shape = MaterialTheme.shapes.extraLarge) {
            Text(text = "2", fontSize = fontSize)
        }
        Button(onClick = {buttonPlus = !buttonPlus}, shape = MaterialTheme.shapes.extraLarge) {
            Text(text = "+", fontSize = fontSize)
        }
    }
}