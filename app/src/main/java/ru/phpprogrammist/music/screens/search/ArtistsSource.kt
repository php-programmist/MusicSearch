package ru.phpprogrammist.music.screens.search

import android.util.Log
import androidx.paging.PositionalDataSource
import ru.phpprogrammist.music.api.ItunesRepositoryProvider
import ru.phpprogrammist.music.data.artists.Artist

class ArtistsSource(val query: String) : PositionalDataSource<Artist>() {
    private val dataProvider = ItunesRepositoryProvider.provideItunesRepository()

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Artist>) {
        Log.i("music_tag","loadInitial. Query - $query. Start - ${params.requestedStartPosition}. Size - ${params.pageSize}")
        val response = dataProvider.searchArtists(query, params.pageSize, params.requestedStartPosition)
        callback.onResult(response.results,0)
        Log.i("music_tag","loadInitial Response count. ${response.resultCount}")
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Artist>) {
        Log.i("music_tag","loadRange. Query - $query. Start - ${params.startPosition}. Size - ${params.loadSize}")
        val response = dataProvider.searchArtists(query, params.loadSize, params.startPosition)
        callback.onResult(response.results)
        Log.i("music_tag","loadRange count. ${response.resultCount}")
    }
}
