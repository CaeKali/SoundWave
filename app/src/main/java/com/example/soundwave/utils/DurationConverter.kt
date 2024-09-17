package com.example.soundwave.utils

import java.util.Locale
import java.util.concurrent.TimeUnit

// utils function to convert song duration in (ms) to text
fun msToText(duration:Long):String{
    val minutes = TimeUnit.MILLISECONDS.toMinutes(duration)
    val seconds = TimeUnit.MILLISECONDS.toSeconds(duration - TimeUnit.MINUTES.toMillis(minutes))
    return String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds)
}