package com.example.soundwave.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.util.Locale
import java.util.concurrent.TimeUnit

@Composable
fun SeekBar(duration:Long,progress:Float,onSeek: (Float) ->Unit){

    Row(
        modifier = Modifier.width(300.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        SongTimeStamp(text = msToText(duration))
        Spacer(modifier = Modifier.width(5.dp))
        Slider(value = progress, onValueChange = { onSeek(it)}, valueRange = 0f..duration.toFloat(), modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.width(5.dp))
        SongTimeStamp(text = msToText(duration))
    }
}

// utils function to convert song duration in (ms) to text
fun msToText(duration:Long):String{
    val minutes = TimeUnit.MILLISECONDS.toMinutes(duration)
    val seconds = TimeUnit.MILLISECONDS.toSeconds(duration - TimeUnit.MINUTES.toMillis(minutes))
    return String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds)
}

@Preview
@Composable
fun SeekBarPreview(){
    SeekBar(870000,0f) { }
}
