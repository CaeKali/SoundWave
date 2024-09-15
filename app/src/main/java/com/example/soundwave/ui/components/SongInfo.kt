package com.example.soundwave.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight

@Composable
fun SongInfo(title:String,artists:String,album:String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        SongInfoText(text = title, fontWeight = FontWeight.Bold)
        SongInfoText(text = artists)
        SongInfoText(text = album)
    }
}