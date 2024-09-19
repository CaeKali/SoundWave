package com.example.soundwave.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.soundwave.R
import com.example.soundwave.models.Song
import com.example.soundwave.utils.msToText


@Composable
fun SongItem(song: Song,onClick: () -> Unit, backgroundColor: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth().background(backgroundColor)
            .padding(5.dp)
            .clickable { onClick()},
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
    Text(text, style = textStyle, overflow = TextOverflow.Ellipsis, maxLines = 1, modifier = modifier)
}

@Composable
fun SongList(songs: List<Song>,currentIndex:Int, onSelectSong: (Song,Int) -> Unit, modifier: Modifier = Modifier) {
  LazyColumn(modifier = modifier) {
        itemsIndexed(songs){index,song ->
            // Highlight the selected song by comparing index
            val backgroundColor =
                if (currentIndex == index) Color(0xFF807767) else Color.Transparent
            SongItem(
                song = song,
                onClick = { onSelectSong(song,index)},
                backgroundColor = backgroundColor
            )
        }
//        items(songs) { song ->
//            SongItem(song, onClick = onClick)
//        }
    }
}