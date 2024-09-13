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
fun SecondRow(){
    val fontSize = Font().fontSize
    Row(modifier = Modifier.background(MaterialTheme.colorScheme.background).fillMaxWidth().padding(bottom=10.dp, top=10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically){
        Button(onClick = {buttonThree = !buttonThree}, shape = MaterialTheme.shapes.extraLarge) {
            Text(text = "3", fontSize = fontSize)
        }
        Button(onClick = {buttonFour = !buttonFour}, shape = MaterialTheme.shapes.extraLarge) {
            Text(text = "4", fontSize = fontSize)
        }
        Button(onClick = {buttonFive = !buttonFive}, shape = MaterialTheme.shapes.extraLarge) {
            Text(text = "5", fontSize = fontSize)
        }
        Button(onClick = {buttonTimes = !buttonTimes}, shape = MaterialTheme.shapes.extraLarge) {
            Text(text = "*", fontSize = fontSize)
        }
    }
}