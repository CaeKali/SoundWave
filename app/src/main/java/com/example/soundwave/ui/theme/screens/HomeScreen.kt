package com.example.soundwave.ui.theme.screens

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.soundwave.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier:Modifier = Modifier){
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Column(modifier = Modifier,horizontalAlignment =  Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(R.drawable.default_album),
                contentDescription = null,
                modifier = Modifier.size(300.dp).clip(
                    RoundedCornerShape(10.dp)
                ),
            )
            Spacer(Modifier.height(20.dp))
            Text(text = "Title", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = "Artist", fontSize = 20.sp)

            Spacer(Modifier.height(30.dp))
            Row(modifier = Modifier.width(300.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "00:00")
                Slider(value = 50f, onValueChange = {

                }, valueRange = 0f..100f,modifier = Modifier.weight(1f))
                Text(text = "00:00")
            }

            Row {
                IconButton(onClick = {

                }) {
                    Icon(painter = painterResource(R.drawable.ic_prev),"previous", tint = Color.Black)
                }
                IconButton(onClick = {

                }) {
                    Icon(painter = painterResource(R.drawable.ic_play),"play or pause",)
                }
                IconButton(onClick = {

                }) {
                    Icon(painter = painterResource(R.drawable.ic_next),"next")
                }

            }

        }
    }
}


@Preview(showBackground =  true)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}