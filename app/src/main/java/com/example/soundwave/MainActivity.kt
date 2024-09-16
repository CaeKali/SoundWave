package com.example.soundwave

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.example.soundwave.ui.theme.SoundWaveTheme
import com.example.soundwave.ui.screens.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SoundWaveTheme {
                SoundWaveApp()
            }
        }
    }
}


@Composable
fun SoundWaveApp(){
    HomeScreen()
}

