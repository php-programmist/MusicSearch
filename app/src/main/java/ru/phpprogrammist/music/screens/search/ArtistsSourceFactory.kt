package ru.phpprogrammist.music.screens.search

import android.util.Log
import androidx.paging.DataSource
import ru.phpprogrammist.music.data.artists.Result
class ArtistsSourceFactory : DataSource.Factory<Int, Result>() {
    var query = ""
    override fun create(): DataSource<Int, Result> {
        Log.i("music_tag","Create ArtistsSource with query - $query")
        return ArtistsSource(query)
    }
}