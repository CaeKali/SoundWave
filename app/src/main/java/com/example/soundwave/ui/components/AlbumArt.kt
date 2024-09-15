package com.example.soundwave.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun AlbumArt(albumArt:Int){
    Image(
        painter = painterResource(albumArt),
        contentDescription = null,
        modifier = Modifier
            .size(300.dp)
            .clip(
                RoundedCornerShape(10.dp)
            ),
    )
}