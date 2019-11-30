package ru.phpprogrammist.music.screens.details

import android.util.Log
import androidx.paging.DataSource
import ru.phpprogrammist.music.data.songs.Song

class SongsSourceFactory : DataSource.Factory<Int, Song>() {
    var artistId = 0
    override fun create(): DataSource<Int, Song> {
        return SongsSource(artistId)
    }
}