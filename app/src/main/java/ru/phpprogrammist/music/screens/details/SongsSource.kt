package ru.phpprogrammist.music.screens.details

import androidx.paging.PositionalDataSource
import ru.phpprogrammist.music.api.ItunesRepositoryProvider
import ru.phpprogrammist.music.data.songs.Song

class SongsSource(val artistId: Int) : PositionalDataSource<Song>() {
    private val dataProvider = ItunesRepositoryProvider.provideItunesRepository()

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Song>) {
        val response = dataProvider.getSongs(artistId, params.pageSize, params.requestedStartPosition)
        callback.onResult(response.results.drop(1),0)
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Song>) {
        /*val response = dataProvider.getSongs(artistId, params.loadSize, params.startPosition)
        callback.onResult(response.results.drop(1))*/
        /*К сожалению, API не поддерживает параметр offset. Поэтому возвращаем пустой список, чтобы сигнализировать о конце списка*/
        callback.onResult(listOf())
    }
}
