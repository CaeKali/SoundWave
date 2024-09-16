package com.example.soundwave.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.soundwave.R
import com.example.soundwave.ui.components.AlbumArt
import com.example.soundwave.ui.components.MediaButton
import com.example.soundwave.ui.components.MediaControls
import com.example.soundwave.ui.components.SeekBar
import com.example.soundwave.ui.components.SongInfo
import com.example.soundwave.ui.components.SoundWaveTopBar
import com.example.soundwave.ui.theme.SoundWaveTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var title by remember {
        mutableStateOf("No Title")
    }
    var artists by remember {
        mutableStateOf("No Artists")
    }
    var album by remember {
        mutableStateOf("No Album")
    }
    var albumArt by remember {
        mutableStateOf(R.drawable.default_album)
    }

    val duration by remember {
        mutableStateOf(0L)
    }
    var progress by remember {
        mutableStateOf(0.0f)
    }

    var isPlaying by remember {
        mutableStateOf(false)
    }

    var isShuffle by remember {
        mutableStateOf(false)
    }

    var isRepeatOne by remember {
        mutableStateOf(false)
    }

    var isFavorite by remember {
        mutableStateOf(false)
    }
    var endTime by remember {
        mutableStateOf("00:00")
    }
    var currentTime by remember {
        mutableStateOf("00:00")
    }

    val favoriteIcon =
        if (isFavorite) R.drawable.ic_favorite_filled else R.drawable.ic_favorite_unfilled


    SoundWaveTheme {
        Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
            SoundWaveTopBar("SoundWave")
        }) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
                    AlbumArt(albumArt)
                    Spacer(Modifier.height(20.dp))
                    SongInfo(title = title, artists = artists, album = album)
                    Spacer(Modifier.height(20.dp))
                    Row(
                        modifier = Modifier.width(300.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        MediaButton(
                            icon = painterResource(favoriteIcon), contentDescription = "Favorite"
                        ) {
                            isFavorite = if (isFavorite) false else true
                        }
                        MediaButton(
                            icon = painterResource(R.drawable.ic_queue_music),
                            contentDescription = "Favorite"
                        ) { }
                    }


                    SeekBar(duration, progress, onSeek = {
                        progress = it
                    })

                    Spacer(modifier = Modifier.height(10.dp))
                    MediaControls(isPlaying = isPlaying,
                        isShuffle = isShuffle,
                        isRepeatOne = isRepeatOne,
                        onShuffleClick = {
                            isShuffle = if (isShuffle) false else true
                        },
                        onRepeatClick = {
                            isRepeatOne = if (isRepeatOne) false else true
                        },
                        onPlayClick = {
                            isPlaying = if (isPlaying) false else true
                        })
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}