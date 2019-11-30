package ru.phpprogrammist.music.screens.details

import androidx.paging.PositionalDataSource
import ru.phpprogrammist.music.api.ItunesRepositoryProvider
import ru.phpprogrammist.music.data.albums.Album

class AlbumsSource(val artistId: Int) : PositionalDataSource<Album>() {
    private val dataProvider = ItunesRepositoryProvider.provideItunesRepository()

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Album>) {
        val response = dataProvider.getAlbums(artistId, params.pageSize, params.requestedStartPosition)
        callback.onResult(response.results.drop(1),0)
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Album>) {
        //val response = dataProvider.getAlbums(artistId, params.loadSize, params.startPosition)
        //callback.onResult(response.results.drop(1))
        /*К сожалению, API не поддерживает параметр offset. Поэтому возвращаем пустой список, чтобы сигнализировать о конце списка*/
        callback.onResult(listOf())
    }
}
