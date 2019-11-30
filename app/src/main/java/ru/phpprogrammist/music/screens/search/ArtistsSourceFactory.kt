package ru.phpprogrammist.music.screens.search

import android.util.Log
import androidx.paging.DataSource
import ru.phpprogrammist.music.data.artists.Artist
class ArtistsSourceFactory : DataSource.Factory<Int, Artist>() {
    var query = ""
    override fun create(): DataSource<Int, Artist> {
        Log.i("music_tag","Create ArtistsSource with query - $query")
        return ArtistsSource(query)
    }
}