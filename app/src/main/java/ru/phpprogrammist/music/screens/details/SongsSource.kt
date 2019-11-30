package ru.phpprogrammist.music.screens.details

import android.util.Log
import androidx.paging.PositionalDataSource
import ru.phpprogrammist.music.api.ItunesRepositoryProvider
import ru.phpprogrammist.music.data.songs.Song

class SongsSource(val artistId: Int) : PositionalDataSource<Song>() {
    private val dataProvider = ItunesRepositoryProvider.provideItunesRepository()

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Song>) {
        Log.i("music_tag","loadInitial. ID - $artistId. Start - ${params.requestedStartPosition}. Size - ${params.pageSize}")
        val response = dataProvider.getSongs(artistId, params.pageSize, params.requestedStartPosition)
        callback.onResult(response.results.drop(1),0)
        Log.i("music_tag","loadInitial Response count. ${response.resultCount}")
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Song>) {
        Log.i("music_tag","loadRange. ID - $artistId. Start - ${params.startPosition}. Size - ${params.loadSize}")
        val response = dataProvider.getSongs(artistId, params.loadSize, params.startPosition)
        callback.onResult(response.results.drop(1))
        Log.i("music_tag","loadRange count. ${response.resultCount}")
    }
}
