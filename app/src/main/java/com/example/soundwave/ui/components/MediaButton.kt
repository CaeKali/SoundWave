package com.example.soundwave.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.soundwave.R

@Composable
fun MediaButton(modifier: Modifier = Modifier,icon:Painter,contentDescription:String,onClick: () -> Unit){
    IconButton(onClick = onClick) {
        Icon(painter = icon,contentDescription = contentDescription, modifier = modifier.size(48.dp))
    }
}
@Preview
@Composable
fun MediaButtonPreview(){
    MediaButton(icon = painterResource(R.drawable.ic_play), contentDescription = "play"){
    }
}