package ru.phpprogrammist.music.screens.details

import androidx.paging.DataSource
import ru.phpprogrammist.music.data.albums.Album

class AlbumsSourceFactory : DataSource.Factory<Int, Album>() {
    var artistId = 0
    override fun create(): DataSource<Int, Album> {
        return AlbumsSource(artistId)
    }
}