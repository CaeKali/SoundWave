package com.example.soundwave.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SongTimeStamp(text:String,modifier: Modifier = Modifier){
    Text(text = text, modifier = modifier)
}