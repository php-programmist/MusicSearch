package ru.phpprogrammist.music.screens.search

import android.util.Log
import androidx.paging.PositionalDataSource
import ru.phpprogrammist.music.api.ItunesRepositoryProvider
import ru.phpprogrammist.music.data.artists.Artist

class ArtistsSource(val query: String) : PositionalDataSource<Artist>() {
    private val dataProvider = ItunesRepositoryProvider.provideItunesRepository()

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Artist>) {
        val response = dataProvider.searchArtists(query, params.pageSize, params.requestedStartPosition)
        callback.onResult(response.results,0)
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Artist>) {
        val response = dataProvider.searchArtists(query, params.loadSize, params.startPosition)
        callback.onResult(response.results)
    }
}
