package com.example.soundwave.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.soundwave.R

@Composable
fun MediaControls(
    isPlaying: Boolean,
    isShuffle: Boolean,
    isRepeatOne: Boolean,
    modifier: Modifier = Modifier,
    onRepeatClick: () -> Unit,
    onShuffleClick: () -> Unit,
    onPlayClick: () -> Unit
) {

    val playPauseIcon = if (isPlaying) R.drawable.ic_pause else R.drawable.ic_play
    val repeatIcon = if (isRepeatOne) R.drawable.ic_repeat_one else R.drawable.ic_repeat
    val shuffleIcon = if (isShuffle) R.drawable.ic_shuffle_on else R.drawable.ic_shuffle

    Row(modifier = Modifier.width(300.dp)) {
        MediaButton(
            icon = painterResource(shuffleIcon), contentDescription = "shuffle"
        ) { onShuffleClick() }
        Spacer(modifier = Modifier.weight(1f))
        MediaButton(
            icon = painterResource(R.drawable.ic_prev), contentDescription = "previous"
        ) { }
        MediaButton(
            icon = painterResource(playPauseIcon),
            contentDescription = "play or pause",
            modifier = Modifier
                .background(
                    Color.Gray
                )

        ) {
            onPlayClick()
        }
        MediaButton(
            icon = painterResource(R.drawable.ic_next), contentDescription = "next"
        ) { }
        Spacer(modifier = Modifier.weight(1f))
        MediaButton(
            icon = painterResource(repeatIcon), contentDescription = "repeat"
        ) {
            onRepeatClick()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MediaControlsPreview() {
//    MediaControls(isPlaying = true, isShuffle = true, isRepeatOne = true)
}