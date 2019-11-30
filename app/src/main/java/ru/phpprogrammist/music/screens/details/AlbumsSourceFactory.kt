package ru.phpprogrammist.music.screens.details

import android.util.Log
import androidx.paging.DataSource
import ru.phpprogrammist.music.data.albums.Album

class AlbumsSourceFactory : DataSource.Factory<Int, Album>() {
    var artistId = 0
    override fun create(): DataSource<Int, Album> {
        Log.i("music_tag","Create AlbumsSource with Id - $artistId")
        return AlbumsSource(artistId)
    }
}