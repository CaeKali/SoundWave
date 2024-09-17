package com.example.soundwave.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.soundwave.R
import com.example.soundwave.models.Song
import com.example.soundwave.ui.components.MediaControls
import com.example.soundwave.ui.components.SongItemText
import com.example.soundwave.ui.components.SongList

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    var isPlaying by remember {
        mutableStateOf(false)
    }

    var currentSong by remember {
        mutableStateOf(
            Song(
                R.string.unknown,
                R.string.unknown,
                R.drawable.default_album,
                R.string.unknown,
                songDuration = 0L
            )
        )
    }
    val songs = listOf(
        Song(
            R.string.unknown, R.string.unknown, R.drawable.ic_genre, R.string.unknown, 5000L
        ),
        Song(
            R.string.unknown, R.string.unknown, R.drawable.ic_genre, R.string.unknown, 5000L
        ),
        Song(
            R.string.unknown, R.string.unknown, R.drawable.ic_genre, R.string.unknown, 5000L
        ),
        Song(
            R.string.unknown, R.string.unknown, R.drawable.ic_genre, R.string.unknown, 5000L
        ),
        Song(
            R.string.unknown, R.string.unknown, R.drawable.ic_genre, R.string.unknown, 5000L
        ),
        Song(
            R.string.unknown, R.string.unknown, R.drawable.ic_genre, R.string.unknown, 5000L
        ),
        Song(
            R.string.unknown, R.string.unknown, R.drawable.ic_genre, R.string.unknown, 5000L
        ),
        Song(
            R.string.unknown, R.string.unknown, R.drawable.ic_genre, R.string.unknown, 5000L
        ),
        Song(
            R.string.unknown, R.string.unknown, R.drawable.ic_genre, R.string.unknown, 5000L
        ),
        Song(
            R.string.unknown, R.string.unknown, R.drawable.ic_genre, R.string.unknown, 5000L
        ),
        Song(
            R.string.unknown, R.string.unknown, R.drawable.ic_genre, R.string.unknown, 5000L
        ),
        Song(
            R.string.unknown, R.string.unknown, R.drawable.ic_genre, R.string.unknown, 5000L
        ),
    )
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = { HomeScreenTopBar() }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Bottom
        ) {
            SongList(songs,
                modifier = Modifier.weight(1f),
                onClick = { song -> currentSong = song })
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
                    .background(color = Color.Gray)
                    .padding(5.dp), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(currentSong.albumArt),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(
                                66.dp, 56.dp
                            )

                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Column(modifier = Modifier.fillMaxWidth()) {
                        SongItemText(
                            text = stringResource(currentSong.songTitle),
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        SongItemText(
                            text = stringResource(currentSong.songArtists),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
                MediaControls(isPlaying = isPlaying,
                    modifier = Modifier.fillMaxHeight(),
                    onPlay = { isPlaying = if (isPlaying) false else true })
            }
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenTopBar() {
    TopAppBar(title = {
        Text(text = "SoundWave", fontWeight = FontWeight.Bold)
    }, actions = {
        IconButton(onClick = {
            // NOT implemented
        }) {
            Icon(painter = painterResource(R.drawable.ic_search), contentDescription = null)
        }
        IconButton(onClick = {
            // NOT implemented
        }) {
            Icon(painter = painterResource(R.drawable.ic_menu), contentDescription = null)
        }
    })
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}