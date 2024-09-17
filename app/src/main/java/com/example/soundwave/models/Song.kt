package com.example.soundwave.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Song(
    @StringRes val songTitle: Int,
    @StringRes val songAlbum: Int,
    @DrawableRes val albumArt:Int,
    @StringRes val songArtists: Int,
    val songDuration: Long
)
