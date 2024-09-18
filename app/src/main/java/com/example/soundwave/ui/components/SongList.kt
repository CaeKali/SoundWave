package com.example.soundwave.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.soundwave.R
import com.example.soundwave.models.Song
import com.example.soundwave.utils.msToText

@Composable
fun SongItem(song: Song, onClick: (Song) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable { onClick(song) },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(song.albumArt),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(
                        56.dp
                    )
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier.weight(1f), verticalArrangement = Arrangement.SpaceBetween
            ) {
                SongItemText(
                    text = stringResource(song.songTitle),
                    modifier = Modifier.fillMaxWidth(),
                    textStyle = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    SongItemText(
                        text = stringResource(song.songAlbum),
                        textStyle = TextStyle(fontSize = 16.sp)
                    )
                    SongItemText(
                        text = msToText(song.songDuration),
                        textStyle = TextStyle(fontSize = 16.sp)
                    )
                }
            }
        }
        IconButton(onClick = {
            // Not Implemented
        }) {
            Icon(painter = painterResource(R.drawable.ic_more_vert), contentDescription = null)
        }
    }
}


@Composable
fun SongItemText(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle.Default
) {
    Text(text, style = textStyle, overflow = TextOverflow.Ellipsis, modifier = modifier)
}

@Composable
fun SongList(songs: List<Song>, onClick: (Song) -> Unit, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(songs) { song ->
            SongItem(song, onClick = onClick)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SongItemPreview() {
    val songs = listOf(
        Song(
            R.string.unknown_title, R.string.unknown_album, R.drawable.default_album, R.string.unknown_artists, songDuration = 0L
        )
    )
    SongList(songs, onClick = {}, modifier = Modifier.fillMaxSize())
}