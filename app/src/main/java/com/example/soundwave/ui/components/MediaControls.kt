package com.example.soundwave.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.soundwave.R

@Composable
fun MediaControls(isPlaying: Boolean, modifier: Modifier = Modifier,onPlay:() -> Unit) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        MediaControl(painter = painterResource(R.drawable.ic_prev), onClick = { })
        MediaControl(
            painter = painterResource(if (isPlaying) R.drawable.ic_pause else R.drawable.ic_play),
            onClick = onPlay)
        MediaControl(painter = painterResource(R.drawable.ic_next), onClick = { })
    }
}

@Composable
fun MediaControl(
    painter: Painter,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
) {
    IconButton(onClick = onClick, modifier = modifier) {
        Icon(painter = painter, contentDescription = contentDescription)
    }
}

@Preview(showBackground = true)
@Composable
fun MediaControlsPreview() {
    MediaControls(isPlaying = true, onPlay = {})
}