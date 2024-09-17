package com.example.soundwave.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.sp

@Composable
fun SongInfoText(text:String, modifier: Modifier = Modifier,fontWeight: FontWeight = FontWeight.Normal){
    Text(text = text, fontWeight = fontWeight, fontSize = 20.sp, textAlign = TextAlign.Center)
}

@Preview
@Composable
fun SongInfoTextPreview(){
    SongInfoText(text = "Null")
}