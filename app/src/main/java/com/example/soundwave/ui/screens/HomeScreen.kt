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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    var currentSongIndex by remember {
        mutableStateOf(0)
    }

    // song with default values
    var currentSong by remember {
        mutableStateOf(
            Song(
                R.string.unknown_title,
                R.string.unknown_album,
                R.drawable.default_album,
                R.string.unknown_artists,
                songDuration = 0L
            )
        )
    }

    val songs = listOf(
        Song(
            R.string.title_1,
            R.string.album_1,
            R.drawable.default_album,
            R.string.artists_1,
            songDuration = 303434L
        ),
        Song(
            R.string.title_2,
            R.string.album_2,
            R.drawable.default_album,
            R.string.artists_2,
            songDuration = 303434L
        ),

        Song(
            R.string.title_3,
            R.string.album_3,
            R.drawable.default_album,
            R.string.artists_3,
            songDuration = 303434L
        ),

        Song(
            R.string.title_4,
            R.string.album_4,
            R.drawable.default_album,
            R.string.artists_4,
            songDuration = 303434L
        ),

        Song(
            R.string.title_5,
            R.string.album_5,
            R.drawable.default_album,
            R.string.artists_5,
            songDuration = 303434L
        ),
    )

    currentSong = songs[currentSongIndex]

    Scaffold(modifier = Modifier.fillMaxSize(), topBar = { HomeScreenTopBar() }, bottomBar = {
        HomeScreenBottomNav()
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Bottom
        ) {
            SongList(songs,
                modifier = Modifier.weight(1f),
                currentIndex = currentSongIndex,
                onSelectSong = { song, index ->
                    currentSong = song
                    currentSongIndex = index
                })


            // mini player
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = Color.DarkGray)
                    .padding(5.dp),
                horizontalArrangement = Arrangement.SpaceBetween
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
                        modifier = Modifier
                            .size(
                                56.dp
                            )
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Column(modifier = Modifier.fillMaxWidth()) {
                        SongItemText(
                            text = LocalContext.current.getString(currentSong.songTitle),
                            modifier = Modifier.fillMaxWidth(),
                            textStyle = TextStyle(
                                fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.White
                            )
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        SongItemText(
                            text = LocalContext.current.getString(currentSong.songArtists),
                            modifier = Modifier.fillMaxWidth(),
                            textStyle = TextStyle(fontSize = 16.sp, color = Color.White)
                        )
                    }
                }
                MediaControls(isPlaying = isPlaying,
                    modifier = Modifier.fillMaxHeight(),
                    onPlay = { isPlaying = if (isPlaying) false else true },
                    onNextClick = {
                        if (currentSongIndex != songs.lastIndex) currentSongIndex++ else currentSongIndex =
                            0
                    },
                    onPrevClick = {
                        if (currentSongIndex != 0) currentSongIndex-- else currentSongIndex =
                            songs.lastIndex
                    })
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
            Icon(painter = painterResource(R.drawable.ic_menu), contentDescription = null)
        }
    })
}


@Composable
fun HomeScreenBottomNav() {
    NavigationBar {
        NavigationBarItem(selected = true, onClick = {
            // NOT implemented
        }, icon = {
            Icon(
                painter = painterResource(R.drawable.ic_home), contentDescription = null
            )
        }, label = {
            Text(text = "Home")
        })
        NavigationBarItem(selected = false, onClick = {
            // NOT implemented
        }, icon = {
            Icon(
                painter = painterResource(R.drawable.ic_favorite), contentDescription = null
            )
        }, label = {
            Text(text = "Favorites")
        })
        NavigationBarItem(selected = false, onClick = {
            // NOT implemented
        }, icon = {
            Icon(
                painter = painterResource(R.drawable.ic_playlist), contentDescription = null
            )
        }, label = {
            Text(text = "Playlist")
        })
        NavigationBarItem(selected = false, onClick = {
            // NOT implemented
        }, icon = {
            Icon(painter = painterResource(R.drawable.ic_search), contentDescription = null)
        }, label = {
            Text(text = "Search")
        })
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}