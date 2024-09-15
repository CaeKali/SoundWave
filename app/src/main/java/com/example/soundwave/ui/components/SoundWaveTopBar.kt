package com.example.soundwave.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.soundwave.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SoundWaveTopBar(title:String){
    TopAppBar(title = {
        Text(text = title, fontWeight = FontWeight.Bold)
    }, actions = {
        TopBarIcon(icon = R.drawable.ic_search, contentDescription = "Search", onClick = {

        })
        TopBarIcon(icon = R.drawable.ic_more_vert, contentDescription = "More Options", onClick = {

        })
    })
}

@Preview
@Composable
fun SoundWaveTopBarPreview(){
    SoundWaveTopBar(title = "SoundWave")
}